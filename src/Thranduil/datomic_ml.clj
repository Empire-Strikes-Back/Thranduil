
(ns Thranduil.datomic-ml
  (:require [clojure.repl :refer :all]
            [datomic.api :as d]
            [nrepl.server :refer [start-server stop-server]]
            [Thranduil.datomic-design]))



(defn -main []
  (prn "sample ml")
  (defonce server (start-server :bind "0.0.0.0" :port 7888)))


(comment 
  
  (keys (ns-publics 'Thranduil.datomic-design))
  
  
  )