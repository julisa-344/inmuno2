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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.navigation.NavHostController
import com.example.appinmunocal.R

@Composable
fun payments3View(navController: NavHostController) {
    Scaffold (
        topBar = { barraSuperiorP3(navController)},
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){
                contenidoP3(navController)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraSuperiorP3(navController: NavHostController) {
    TopAppBar(
        modifier = Modifier,
        title = { Text("Pagos") },
        navigationIcon = {
            IconButton(onClick = {navController.navigate("payments2")}) {
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
fun contenidoP3(navController: NavHostController) {

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
                .height(250.dp))

            Column(modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(R.drawable.visa),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .size(width = 225.dp, height = 100.dp)
                )

                Spacer(modifier = Modifier
                    .height(120.dp)
                )

                Button(modifier = Modifier
                    .size(width = 300.dp, height = 55.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    onClick = {
                        navController.navigate("payments4")
                    }
                ) {
                    Text("Procesar Pago",
                        modifier = Modifier,
                        color = Color.White)
                }
            }
        }
    }
}
