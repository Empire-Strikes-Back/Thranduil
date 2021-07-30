(ns conj.aq
  (:require [conj.aq-nrepl]
            ; [dq.psql]
            [cors.server]
            [conj.aq-conn :refer [conn db]]
            ; [dq.server]
            ; [dq.schema]
            ; [dq.query]
            ; [dq.etl]
            ))

(defn -main []
  (prn conn)
  (conj.aq-nrepl/-main)
  (cors.server/run-dev)
  ; (aq.server/start)
  )

