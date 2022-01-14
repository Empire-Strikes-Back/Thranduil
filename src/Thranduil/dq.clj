(ns Thranduil.dq
  (:require [datomic.api :as d]
            [Thranduil.dq-nrepl]
            [Thranduil.dq-psql]
            [Thranduil.dq-conn :refer [conn db]]
            [Thranduil.dq-server]
            [Thranduil.dq-schema]
            [Thranduil.dq-query]
            [Thranduil.dq-etl]
            ))

(defn -main []
  (prn conn)
  (Thranduil.dq-nrepl/-main)
  (Thranduil.dq-server/start))

