(ns Thranduil.datomic-tx
  (:require [datomic.api :as d]
            [clojure.repl :refer :all]
            [nrepl.server :refer [start-server stop-server]]
            [clojure.pprint :as pp]))

(def db-uri "datomic:dev://datomicdb:4334/mbrainz-1968-1973")

(declare conn db)

(comment

  (def conn (d/connect db-uri))

  (def db (d/db conn))

  ;
  )

(defn cdb [] (d/db conn))

(defn -main []
  (defonce server (start-server :host "0.0.0.0" :port 7888)))

(comment
  
  db
  
  (def basis-t (d/basis-t db))
  
  (def basis-tx (d/t->tx basis-t))
  
  (d/pull db '[*] basis-tx)
  
  (def log (d/log conn))
  
  (-> (d/tx-range log basis-tx (inc basis-tx)) 
      seq first :data count
      )
  
  )