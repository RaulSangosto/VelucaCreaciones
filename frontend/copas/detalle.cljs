(ns copas.detalle
  (:require [ui.widgets.core :as w]
            [reagent.core :as r]
            [o2w.api.core :as api]
            [app.db :as db]))

(defonce copa (r/atom nil))

(defn page [_ {:keys [pk slug]}]
  [:div
   [:div.title
    [:h1.t (:titulo @db/cabecera)]
    [:h1.subt (:subtitulo @db/cabecera)]]
   [w/seccion {:titulo "Detalles de la Copa"
               :c      w/copa
               :data   copa}]])
