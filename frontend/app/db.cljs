(ns app.db
  (:require [o2w.api.core :as api]
            [reagent.core :as r]))

(defonce cabecera (r/atom nil))
(defonce categorias (r/atom nil))
(defonce copas (r/atom nil))