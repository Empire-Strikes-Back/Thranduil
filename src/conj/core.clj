(ns conj.core
  (:require [nrepl-server]
            [clojure.repl :refer :all]
            [clojure.pprint :as pp]
            [conj.reference]
            [conj.guides]
            [conj.guides-spec]
            
            ))




(defn -main []
  (nrepl-server/-main))