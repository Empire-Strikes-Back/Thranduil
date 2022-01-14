(ns Thranduil.datomic
  (:require [clojure.repl :refer :all]
            [Thranduil.datomic-nrepl]
            [Thranduil.datomic-server]
            [Thranduil.datomic-design]
            [Thranduil.datomic-mbrainz]
            [Thranduil.datomic-schema]
            [Thranduil.datomic-movies]
            [Thranduil.datomic-hello]
            [Thranduil.datomic-git-codeq]
            [Thranduil.datomic-git-clojure]
            [Thranduil.datomic-dev]
            [Thranduil.datomic-design]))

(defn -main []
  (prn "starting server 8890 and nREPL 7888")
  (Thranduil.datomic-nrepl/-main)
  (Thranduil.datomic-server/start)
  )