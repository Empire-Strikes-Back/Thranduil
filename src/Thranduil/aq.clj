(ns Thranduil.aq
  (:require [Thranduil.aq-nrepl]
            ; [dq.psql]
            [Thranduil.cors-server]
            [Thranduil.aq-conn :refer [conn db]]
            [Thranduil.aq-nrepl]
            [Thranduil.aq-query]
            ; [dq.server]
            ; [dq.schema]
            ; [dq.query]
            ; [dq.etl]
            ))

(defn -main []
  (prn conn)
  (Thranduil.aq-nrepl/-main)
  (Thranduil.cors-server/run-dev)
  ; (aq.server/start)
  )

