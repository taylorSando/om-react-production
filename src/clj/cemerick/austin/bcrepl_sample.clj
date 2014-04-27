(ns cemerick.austin.bcrepl-sample
  (:require [cemerick.austin.repls :refer (browser-connected-repl-js)]
            [net.cgrand.enlive-html :as enlive]
            [compojure.route :refer (resources)]
            [compojure.core :refer (GET defroutes)]  
            ring.adapter.jetty
            [clojure.java.io :as io]))                                 

(enlive/deftemplate dev-index
  (io/resource "dev-index.html")
  []
  [:body] (enlive/append
            (enlive/html [:script (browser-connected-repl-js)])))

(enlive/deftemplate index
  (io/resource "index.html")
  [])

(defroutes dev-site 
  (resources "/" {:root "dev"} ) 
  (GET "/*" req (dev-index)))

(defroutes site
  (resources "/")
  (GET "/*" req (index)))

(defn run
  [& [type]]  
  (if (and type (= type :dev))
    (def ^:private server
      (ring.adapter.jetty/run-jetty #'dev-site {:port 3000 :join? false}))
    (def ^:private server
      (ring.adapter.jetty/run-jetty #'site {:port 3000 :join? false})))
  server)

(comment
  (.stop server)
  (.start server)
  (run :dev)
  (run)
  )




