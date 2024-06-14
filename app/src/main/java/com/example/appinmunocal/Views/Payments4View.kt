package com.example.appinmunocal.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.appinmunocal.R

@Composable
fun payments4View(navController: NavHostController) {
    Scaffold (
        topBar = { barraSuperiorP4(navController)},
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){
                contenidoP4(navController)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraSuperiorP4(navController: NavHostController) {
    TopAppBar(
        modifier = Modifier,
        title = { Text("Pagos") },
        navigationIcon = {
            IconButton(onClick = {navController.navigate("payments1")}) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "retorno", tint = Color.White)
            }
        },
        actions = {

        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.surfaceVariant
        )
    )
}

@Composable
fun contenidoP4(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Top
        ) {

            Spacer(modifier = Modifier
                .height(60.dp)
            )

            Box(modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(R.drawable.check),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .size(width = 325.dp, height = 200.dp)
                )
            }
            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){

                Text("Transacción Exitosa",
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier
                    .height(5.dp)
                )
                Text("Has pagado S/ 100.00 a NaturalHome",
                    color = Color.Black.copy(alpha = 0.5f))

                Spacer(modifier = Modifier
                    .height(100.dp)
                )

                Row(verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        modifier = Modifier
                    )

                    Text("Secured by")
                    Text(" PayStack",
                        fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}