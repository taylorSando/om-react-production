(defproject com.cemerick/austin-repl-sample "NOT_DEPLOYED"
  :source-paths ["src/clj" "src/cljs"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2197"]
                 [om "0.6.2"]
                 [ring "1.2.1"]
                 [compojure "1.1.6"]
                 [enlive "1.1.5"]]
  :cljsbuild {:builds [{:source-paths ["src/cljs"]
                                         :compiler {:output-to "resources/dev/out/main.js"
                                                    :output-dir "resources/dev/out"
                                                    :source-map true
                                                    :optimizations :none
                                                    :pretty-print true}}
                                        {:source-paths ["src/cljs"]
                                         :compiler {:output-to "resources/public/main.js"
                                                    ;:preamble ["react/react.min.js"]
                                                    :externs ["react/externs/react.js"]
                                                    :closure-warnings {:externs-validation :off
                                                                       :non-standard-jsdoc :off}
                                                    :pretty-print false
                                                    :optimizations :advanced}}]}
  
  :profiles {:dev {:repl-options {:init-ns cemerick.austin.bcrepl-sample}
                   :plugins [[com.cemerick/austin "0.1.5-SNAPSHOT"]
                             [lein-cljsbuild "1.0.3"]]}})

