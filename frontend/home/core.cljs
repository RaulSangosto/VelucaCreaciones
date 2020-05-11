(ns home.core
  (:require [o2w.api.core :as api]
            [reagent.core :as r]
            [app.db :as db]
            [ui.widgets.core :as w]))

(defonce copas (r/atom nil))

(api/get "copas" {:ok #(reset! copas %)})

(defn page []
  [:<>
    [:div.title
     [:h1.t (:titulo @db/cabecera)]
     [:h1.subt (:subtitulo @db/cabecera)]]
   [w/seccion {:titulo "Nuestros últimos encargos"
             :c      w/copa
             :data   copas}]
   [w/seccion {:titulo "Lo que opinan nuestros clientes"
               :c      w/copa
               :data   copas}]])