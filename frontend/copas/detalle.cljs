(ns copas.detalle)


(defn page [{:keys [pk]}]
  [:div
   [:h1 (str "Detalle de la copa" pk)]])
