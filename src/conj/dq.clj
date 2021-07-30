(ns conj.dq
  (:require [datomic.api :as d]
            [conj.dq-nrepl]
            [conj.dq-psql]
            [conj.dq-conn :refer [conn db]]
            [conj.dq-server]
            [dq.schema]
            [conj.dq-query]
            [conj.dq-etl]
            ))

(defn -main []
  (prn conn)
  (conj.dq-nrepl/-main)
  (conj.dq-server/start))

