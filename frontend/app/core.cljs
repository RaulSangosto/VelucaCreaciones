(ns app.core
  (:require [reagent.core :as r]
            [app.db :as db]
            [app.views]
            [o2w.routes]
            [app.routes]))

(defn mount-app []
  (r/render [app.views/main-app]
            (js/document.getElementById "app")))

(defn init []
  (o2w.routes/start! {:routes app.routes/routes
                      :views  app.routes/views})
  (mount-app))