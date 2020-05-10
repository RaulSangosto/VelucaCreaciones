(ns copas.detalle)


(defn page [_ {:keys [pk slug]}]
  [:div
   [:h1 (str "Detalle de la copa" slug)]])
