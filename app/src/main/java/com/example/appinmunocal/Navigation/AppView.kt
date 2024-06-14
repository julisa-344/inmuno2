package com.example.appinmunocal.Navigation

open class AppView (val route: String){
    object payments1: AppView("payments1")
    object payments2: AppView("payments2")
    object payments3: AppView("payments3")
    object payments4: AppView("payments4")
    object suscripciones: AppView("suscripciones")
    object cart: AppView("cart")
    object detailSub: AppView("detail_sub")
    object myShops: AppView("myShops")
    object Products: AppView("products")
    object actualSubView: AppView("actualSub")
    object promosView: AppView("promos")
    object homeView: AppView("home")
    object detailproducts: AppView("detail_products")
}
