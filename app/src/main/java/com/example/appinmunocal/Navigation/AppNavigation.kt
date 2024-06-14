package com.example.appinmunocal.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appinmunocal.R
import com.example.appinmunocal.Views.ActualSubView
import com.example.appinmunocal.Views.CartView
import com.example.appinmunocal.Views.Categoria
import com.example.appinmunocal.Views.Producto
import com.example.appinmunocal.Views.DetailSubView
import com.example.appinmunocal.Views.MyShops
import com.example.appinmunocal.Views.ProductsView
import com.example.appinmunocal.Views.PromosView
import com.example.appinmunocal.Views.SuscripcionView
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

        composable(AppView.suscripciones.route) { SuscripcionView(navController) }
        composable(AppView.detailSub.route) { DetailSubView(navController) }
        composable(AppView.actualSubView.route) { ActualSubView(navController)  }
        composable(AppView.cart.route) { CartView(navController) }
        composable(AppView.myShops.route) { MyShops(navController) }
        composable(AppView.detailProduct.route) {
            val categorias = listOf(
                Categoria("Salud", R.drawable.salud),
                Categoria("Nutricion", R.drawable.nutricion),
                Categoria("Deporte", R.drawable.deporte),
                Categoria("Mental", R.drawable.mental),
                Categoria("Suplemento", R.drawable.suplementos),
            )
            val productos = listOf(
                Producto("Immunocal", R.drawable.immunocal_platinum),
                Producto("Knutric +", R.drawable.omega1),
                Producto("Immunocal", R.drawable.inmunox2),
                Producto("Knutric +", R.drawable.knutric1)
            )
            val cantidadEnCarrito = remember { mutableStateOf(0) }

            ProductsView(
                categorias = categorias,
                productos = productos,
                cantidadEnCarrito = cantidadEnCarrito.value,
                onRegresarClicked = { /* TODO */ },
                onCarritoClicked = { /* TODO */ },
                onAgregarAlCarrito = { producto ->
                    cantidadEnCarrito.value++
                }
            )
        }
        composable(AppView.promosView.route) { PromosView(navController)  }

    }
}


