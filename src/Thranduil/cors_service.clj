

(ns Thranduil.cors-service
  (:require [clojure.java.io :as io]
            [clojure.core.async :as async]
            [io.pedestal.log :as log]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]
            [io.pedestal.http.route.definition :refer [defroutes]]
            [io.pedestal.http.sse :as sse]
            [ring.util.response :as ring-resp]
            [ring.middleware.cors :as cors]
            [Thranduil.aq-conn]
            [Thranduil.aq-query]
            [Thranduil.cors-handlers-health]
            [Thranduil.cors-handlers-query]
            ))

;; If this looks familiar, it's very similar to the server-sent-events sample!
;; have a look at that sample if it's not immediately apparent what's happening
;; in send-counter and sse-stream-ready. The important part is in the service
;; definition.

(defn send-counter
  "Counts down to 0, sending value of counter to sse context and
  recursing on a different thread; ends event stream when counter
  is 0."
  [event-ch count-num]
  (async/put! event-ch {:name "count"
                        :data (str count-num ", thread: " (.getId (Thread/currentThread)))})
  (Thread/sleep 1500)
  (if (> count-num 0)
    (recur event-ch (dec count-num))
    (do
      (async/put! event-ch {:name "close" :data ""})
      (async/close! event-ch))))

(defn sse-stream-ready
  "Starts sending counter events to client."
  [event-ch ctx]
  (let [{:keys [request response-channel]} ctx]
    (send-counter event-ch 10)))


(defn gen-resp []
  {:status 200 :body (str {:data "ok"})})

(defn respond-hello [request]
  (gen-resp))


;; Where are the html and javascript files?
;; They are served statically from resources/public/
(defroutes routes
  [[
    ["/"   {:get [::send-stuff (sse/start-event-stream sse-stream-ready)]}]
    ["/health" {:get [::health cors.handlers.health/handler ]} ]
    ["/entity-params"  {:get [::entity-params cors.handlers.query/entity-params]}]
    ["/entity"  {:get [::entity cors.handlers.query/entity]}]
    ]])



(def service {:env :prod
              ::http/routes routes
              ;; Allow services that are accessing this
              ;; service from a http-referer[sic] of http://localhost:8080.
              ;; All others are denied.
              ::http/allowed-origins ["*"]
              ::http/resource-path "/public"
              ::http/type :jetty
              ::http/host "0.0.0.0"
              ;; Run this service on port 8081 (not default).
              ::http/port 8081})
