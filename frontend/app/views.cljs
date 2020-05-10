(ns app.views
  (:require [o2w.routes]
            [ui.header]
            [ui.footer]))

(defn main-app []
  [:div
   [ui.header/default]
   [o2w.routes/current-view]
   [ui.footer/default]
   ])