package com.example.appinmunocal.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun payments1View(navController: NavHostController) {
    Scaffold (
        topBar = { barraSuperior(navController)},
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){
                contenidoP1(navController)
            }
        },
        bottomBar = { barraInferior(navController)}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraSuperior(navController: NavHostController) {
    TopAppBar(
        modifier = Modifier,
        title = { Text("Pagos") },
        navigationIcon = {
            IconButton(onClick = {navController.navigate("vista1")}) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "retorno", tint = Color.White)
            }
        },
        actions = {

        },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.surfaceVariant
        )
    )
}

@Composable
fun contenidoP1(navController: NavHostController) {
    var numeroTarjeta by remember { mutableStateOf("") }
    var fechaExp by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }
    var limpiarCampos by remember {mutableStateOf(false)}
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column (modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
            verticalArrangement = Arrangement.Top
        ){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.tarjeta),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .size(width = 325.dp, height = 200.dp)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Ingrese los datos de su tarjeta",
                    fontWeight = FontWeight.Bold
                )
                OutlinedTextField(
                    value = numeroTarjeta,
                    onValueChange = { nuevoNumero ->
                        numeroTarjeta = nuevoNumero
                    },
                    label = { Text("Número de tarjeta") },
                    singleLine = true,
                    modifier = Modifier
                        .width(300.dp)
                )
                Row() {
                    OutlinedTextField(
                        value = fechaExp,
                        onValueChange = { nuevaFecha ->
                            fechaExp = nuevaFecha
                        },
                        label = { Text("MM/YY") },
                        singleLine = true,
                        modifier = Modifier
                            .width(145.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .width(10.dp)
                    )

                    OutlinedTextField(
                        value = cvv,
                        onValueChange = { nuevoCVV ->
                            cvv = nuevoCVV
                        },
                        label = { Text("CVV") },
                        singleLine = true,
                        modifier = Modifier
                            .width(145.dp)
                    )

                }
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )
                Button(modifier = Modifier
                    .size(width = 300.dp, height = 55.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Green),
                    onClick = {
                        navController.navigate("payments2")
                    }
                ) {
                    Text(
                        "Procesar Pago",
                        modifier = Modifier,
                        color = Color.White
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )

                Row() {
                    OutlinedButton(modifier = Modifier
                        .size(width = 120.dp, height = 45.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Gray.copy(alpha = 0.5f)),
                        onClick = {
                            numeroTarjeta = ""
                            fechaExp = ""
                            cvv = ""
                            limpiarCampos = !limpiarCampos
                        }
                    ) {
                        Text(
                            "Limpiar",
                            modifier = Modifier,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    }

                    Spacer(
                        modifier = Modifier
                            .width(10.dp)
                    )

                    OutlinedButton(modifier = Modifier
                        .size(width = 120.dp, height = 45.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Red.copy(alpha = 0.5f)),
                        onClick = {
                            navController.navigate("home")
                        }
                    ) {
                        Text(
                            "Cancelar",
                            modifier = Modifier,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(130.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        modifier = Modifier
                    )

                    Text("Secured by")
                    Text(
                        " PayStack",
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}


@Composable
fun barraInferior(navController: NavHostController) {
    BottomAppBar(
        modifier = Modifier,
        containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
        contentColor = MaterialTheme.colorScheme.surface,
        actions = {
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                IconButton(onClick = { navController.navigate("menu") }) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                    )
                }
                IconButton(onClick = { navController.navigate("suscripciones") }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                    )
                }
                IconButton(onClick = { navController.navigate("cart") }) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                    )
                }
                IconButton(onClick = { navController.navigate("vista2") }) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                    )
                }
            }
        }
    )
}

