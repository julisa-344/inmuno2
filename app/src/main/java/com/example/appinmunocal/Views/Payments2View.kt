package com.example.appinmunocal.Views

import com.example.appinmunocal.R

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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@Composable
fun payments2View(navController: NavHostController) {
    Scaffold (
        topBar = { barraSuperiorP2(navController)},
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){
                contenidoP2(navController)
            }
        },
        bottomBar = { barraInferiorP2(navController)}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraSuperiorP2(navController: NavHostController) {
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
fun contenidoP2(navController: NavHostController) {
    var codigo by remember { mutableStateOf("") }
    var limpiarCampos by remember {mutableStateOf(false)}
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
            Spacer(
                modifier = Modifier
                    .height(60.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Image(
                    painter = painterResource(R.drawable.bcp),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .size(width = 120.dp, height = 90.dp)
                )
                Image(
                    painter = painterResource(R.drawable.visa),
                    contentDescription = "Descripción de la imagen",
                    modifier = Modifier
                        .size(width = 120.dp, height = 90.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Detalles de la transacción:")

                Spacer(
                    modifier = Modifier
                        .height(30.dp)
                )

                Row() {
                    Text("Negocio:")
                    Text(" NaturalHome")
                }
                Row() {
                    Text("Monto total:")
                    Text(" S/100.00")
                }
                Row() {
                    Text("Tarjeta:")
                    Text(" **** **** **** 1234")
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Código:   ")
                    OutlinedTextField(
                        value = codigo,
                        onValueChange = { nuevoCodigo ->
                            codigo = nuevoCodigo
                        },
                        label = { Text("Código") },
                        singleLine = true,
                        modifier = Modifier
                            .width(100.dp)
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                )

                Column() {
                    OutlinedButton(modifier = Modifier
                        .size(width = 160.dp, height = 45.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(Color.Gray.copy(alpha = 0.5f)),
                        onClick = {
                            codigo = ""
                            limpiarCampos = !limpiarCampos

                        }
                    ) {
                        Text(
                            "Nuevo código",
                            modifier = Modifier,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    }
                }

                Spacer(
                    modifier = Modifier
                        .height(40.dp)
                )

                OutlinedButton(modifier = Modifier
                    .size(width = 120.dp, height = 45.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Green.copy(alpha = 0.9f)),
                    onClick = {
                        navController.navigate("payments3")
                    }
                ) {
                    Text(
                        "Procesar",
                        modifier = Modifier,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }

                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                )

                OutlinedButton(modifier = Modifier
                    .size(width = 120.dp, height = 45.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.buttonColors(Color.Red.copy(alpha = 0.5f)),
                    onClick = {
                        navController.navigate("payments1")
                    }
                ) {
                    Text(
                        "Cancelar",
                        modifier = Modifier,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                }
                Spacer(
                    modifier = Modifier
                        .height(64.dp)
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
fun barraInferiorP2(navController: NavHostController) {
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
                IconButton(onClick = { navController.navigate("vista2") }) {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null,
                        modifier = Modifier
                            .size(35.dp)
                    )
                }
                IconButton(onClick = { navController.navigate("vista2") }) {
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







