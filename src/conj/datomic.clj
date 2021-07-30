(ns conj.datomic
  (:require [clojure.repl :refer :all]
            [core.nrepl]
            [core.server]
            [conj.datomic-design]
            [core.mbrainz]
            [core.schema]
            ))

(defn -main []
  (prn "starting server 8890 and nREPL 7888")
  (core.nrepl/-main)
  (core.server/start)
  )