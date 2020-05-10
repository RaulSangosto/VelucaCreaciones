(ns copas.core
  (:require [ui.widgets.core :as w]
            [reagent.core :as r]
            [o2w.api.core :as api]
            [app.db :as db]))

(defonce copas (r/atom nil))

(defn page [_ {:keys [pk slug]}]
  [:<>
   [api/source copas {:endpoint "copas"
                      :params {:categoria pk}}]
   [:div
    [:div.title
     [:h1.t (:titulo @db/cabecera)]
     [:h1.subt (:subtitulo @db/cabecera)]]
[w/seccion {:titulo "Copas en Stock"
            :c      w/copa
            :data   copas}]]])
