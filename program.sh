#!/bin/bash

repl(){
  clj \
    -J-Dclojure.core.async.pool-size=1 \
    -X:repl Ripley.core/process \
    :main-ns Thranduil.main
  # clj -R:nREPL -m nrepl.cmdline -i
}

connect7888(){
  clj -Sdeps '{:deps {nrepl {:mvn/version "0.5.3"}}}' -m nrepl.cmdline --connect --host 127.0.0.1 --port 7888
}

nrepl_cljs(){
  clj -R:nREPL -m nrepl.cmdline --middleware "[cider.piggieback/wrap-cljs-repl]"
}

init(){
  clojure -m core
}


# wget https://s3.amazonaws.com/mbrainz/datomic-mbrainz-1968-1973-backup-2017-07-20.tar -O mbrainz.tar
# tar -xvf mbrainz.tar

load_mbrainz(){
    bin/datomic restore-db file:///opt/datomic-pro/mbrainz-1968-1973 datomic:dev://datomicdb:4334/mbrainz-1968-1973
    bin/datomic restore-db file:///opt/datomic-pro/mbrainz-1968-1973 datomic:free://datomicdbfree:4334/mbrainz-1968-1973
    clojure -m initdev
}


lein_repl(){
  # lein repl :headless :host 0.0.0.0 :port 35543
  lein repl :start :host 0.0.0.0 :port 35543
}

lein_conn(){
  lein repl :connect 0.0.0.0:35543
}


run_scheme(){
  scheme 

  # (load "src/Thranduil/little-schemer.scm")
}

load_codeqs(){

  echo hello

  import_codeq(){
      java -server -Xmx1g -jar target/codeq-0.1.0-SNAPSHOT-standalone.jar datomic:free://datomicdbfree:4334/codeq
  }

  import_clojure(){
      java -server -Xmx1g -jar codeq-0.1.0-SNAPSHOT-standalone.jar datomic:free://datomicdbfree:4334/git
  }

  cd codeq
  lein uberjar
  import_codeq &
  # java -server -Xmx1g -jar target/codeq-0.1.0-SNAPSHOT-standalone.jar datomic:free://datomicdbfree:4334/codeq
  cd ../clojure
  # echo $pwd
  cp ../codeq/target/codeq-0.1.0-SNAPSHOT-standalone.jar ./
  import_clojure &

  # ls
  # java -server -Xmx1g -jar codeq-0.1.0-SNAPSHOT-standalone.jar datomic:free://datomicdbfree:4334/git




  tail -f /dev/null
}


"$@"
