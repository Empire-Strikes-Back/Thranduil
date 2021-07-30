(ns conj.dq-nrepl 
  (:require [nrepl.server :refer [start-server stop-server]]
            [clojure.repl :refer :all]))

(defn -main []
  (defonce server (start-server :bind "0.0.0.0" :port 7888)))

(comment
  
  (+ 1 1)
  (+)
  
  (ns conj.dq)
  
  (defn respond-hello [request]
    {:status 200 :body "applause!"})
  
  (conj.dq/respond-hello 1)

  (keys (ns-publics 'clojure.core))

  (doc ->>)
  
  (doc ->)

  
  )