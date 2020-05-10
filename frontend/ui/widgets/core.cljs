(ns ui.widgets.core
  (:require [o2w.routes :as routes]))

(defn seccion [{:keys [titulo c data]}]
  ^{:key titulo}
  [:div.seccion
   [:h1.titulo titulo]
   (doall (map c @data))])

(defn copa [{:keys [id nombre slug imagen]}]
  ^{:key id}
  [:div.col-4>div.card
   [:a {:href (routes/url :copas/detalle {:pk id :slug slug})}
    [:img {:src imagen}]
    [:h2 nombre]]])