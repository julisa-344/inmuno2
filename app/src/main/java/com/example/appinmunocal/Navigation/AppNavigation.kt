package com.example.appinmunocal.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalWithComputedDefaultOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appinmunocal.R
import com.example.appinmunocal.Views.ActualSubView
import com.example.appinmunocal.Views.CartView
import com.example.appinmunocal.Views.Categoria
import com.example.appinmunocal.Views.DetailPerfilView
import com.example.appinmunocal.Views.DetailProductosView
import com.example.appinmunocal.Views.Producto
import com.example.appinmunocal.Views.DetailSubView
import com.example.appinmunocal.Views.HomeView
import com.example.appinmunocal.Views.MicuentaView
import com.example.appinmunocal.Views.MyShops
import com.example.appinmunocal.Views.ProductsView
import com.example.appinmunocal.Views.PromosView
import com.example.appinmunocal.Views.SuscripcionView
import com.example.appinmunocal.Views.UserProfile
import com.example.appinmunocal.Views.payments1View
import com.example.appinmunocal.Views.payments2View
import com.example.appinmunocal.Views.payments3View
import com.example.appinmunocal.Views.payments4View

@Composable
fun appNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppView.payments1.route) {
        composable(AppView.payments1.route){payments1View(navController)}
        composable(AppView.payments2.route){payments2View(navController)}
        composable(AppView.payments3.route){payments3View(navController)}
        composable(AppView.payments4.route){payments4View(navController)}

        composable (AppView.homeView.route){ HomeView(navController) }
        composable(AppView.detailproducts.route) { DetailProductosView(navController) }
        composable(AppView.suscripciones.route) { SuscripcionView(navController) }
        composable(AppView.detailSub.route) { DetailSubView(navController) }
        composable(AppView.actualSubView.route) { ActualSubView(navController)  }
        composable(AppView.cart.route) { CartView(navController) }
        composable(AppView.myShops.route) { MyShops(navController) }
        composable(AppView.Products.route) { ProductsView( navController) }
        composable(AppView.promosView.route) { PromosView(navController)  }

        composable(AppView.micuentaView.route) { MicuentaView(navController)  }
        composable(AppView.detailPerfilView.route) {
            DetailPerfilView(navController)
        }
    }
}


