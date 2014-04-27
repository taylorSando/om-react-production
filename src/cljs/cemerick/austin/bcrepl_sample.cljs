(ns cemerick.austin.bcrepl-sample
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            ;[clojure.browser.repl]
            ))

(om/root
 (fn [app owner]
   (reify
     om/IRender
     (render [this]
       (dom/h2 nil "Hello World")
       )))
 (atom {})
 {:target (. js/document (getElementById "app"))})


