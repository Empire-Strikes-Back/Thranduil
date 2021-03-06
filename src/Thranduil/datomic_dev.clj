(ns Thranduil.datomic-dev
  (:require [clj-time.core :as t]
            [nrepl.server :refer [start-server stop-server]]
            [clj-time.format :as f]
            [datomic.api :as d]
            [Thranduil.datomic-rules :refer (rules)]))

; (def cfg {:server-type :peer-server
;           :access-key "myaccesskey"
;           :secret "mysecret"
;           :endpoint "datomicdb:4334"})


;   (def db-uri "datomic:dev://datomicdb:4334/dayofdatomic")



; (d/create-database db-uri)
; (def conn (d/connect db-uri))

; (def db (d/db conn))

(defn echo [] "echo")

(defn create-delete-db [name]
  (def db-uri (str "datomic:dev://datomicdb:4334/" name ))
  (d/delete-database db-uri)
  (d/create-database db-uri)
  )

(defn create-delete-dayofdatomic []
  (create-delete-db "dayofdatomic")
  )

(defn -main [] 
;   (println conn)
  (println "started server on 7888")
  (defonce server (start-server :bind "0.0.0.0" :port 7888)))

(comment
  
  (d/create-database db-uri)
  (def conn (d/connect db-uri))
  
  (def db (d/db conn))
  (def db-uri "datomic:dev://datomicdb:4334/dayofdatomic")
  
  (d/attribute db :idea/designs)
  
  (d/delete-database db-uri)
  
  (d/create-database db-uri)
  
  (d/squuid)
  
  
  )