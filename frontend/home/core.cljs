(ns home.core
  (:require [o2w.api.core :as api]
            [reagent.core :as r]
            [ui.widgets.core :as w]))

(defonce copas (r/atom nil))

(api/get "copas" {:ok #(reset! copas %)})

(defn seccion [{:keys [titulo c data]}]
  ^{:key titulo}
  [:div {:style {:margin         "25px 0"
                 :padding-bottom "25px"
                 :border-bottom  "1px solid #f0f0f0"}}
   [:h1 titulo]
   (doall (map c @data))])

(defn page []
  [:<>
   [seccion {:titulo "Últimas copas"
             :c      w/copa
             :data   copas}]])