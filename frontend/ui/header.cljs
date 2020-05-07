(ns ui.header
  (:require ui.menu))

(defn default []
  [:header.u-clearfix
   [:div.logo
    [:a {:href "/"}
     [:h2 "música"]]]

   [:div
    [ui.menu/default]]])