(ns app.routes
  (:require home.core
            copas.core
            copas.detalle
            contactar.core))

(def views {:home            #'home.core/page
            :copas           #'copas.core/page
            :copas/detalle   #'copas.detalle/page
            :contactar       #'contactar.core/page})
(def routes
  [["/"            :home]
   ["/copas"       :copas]
   ["/copas/:pk"  :copas/detalle]
   ["/contactar"   :contactar]])
