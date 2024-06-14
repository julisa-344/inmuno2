package com.example.appinmunocal.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appinmunocal.R

@Composable
fun CartView(navController: NavHostController) {
    Scaffold (
        topBar = { barraSuperiorcart(navController)},
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){
                CartViewContent(navController)
            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraSuperiorcart(navController: NavHostController) {
    TopAppBar(
        modifier = Modifier,
        title = { Text("Carrito de compras") },
        navigationIcon = {
            IconButton(onClick = {navController.navigate("products")}) {
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
fun ItemProductCart() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Divider()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 1.dp)
        ) {
            Column(modifier = Modifier
                .padding(16.dp)
                .height(70.dp)
                ,) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(painter = painterResource(id = R.drawable.inmunox2), contentDescription = null)
                    Spacer(modifier = Modifier.size(30.dp))
                    Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            "Inmunox",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.labelMedium,
                            color = colorResource(R.color.neutral_600),
                            fontWeight = FontWeight.Bold
                        )
                        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                            Text(
                                " x 1",
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(R.color.neutral_500),
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                "Precio: $100",
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(R.color.primary_600),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ItemProductDelivery(
    deliveryType: String,
    deliveryTime: String,
    price: String,
    imageResId: Int
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 1.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .height(50.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                    )
                    Spacer(modifier = Modifier.size(30.dp))
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = deliveryType,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.labelMedium,
                            color = colorResource(R.color.neutral_600),
                            fontWeight = FontWeight.Bold
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = deliveryTime,
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(R.color.neutral_500),
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "$price",
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(R.color.primary_600),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CartViewContent(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.neutral_100))
        .verticalScroll(rememberScrollState())
    ){
        Column (modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.neutral_100))
        ){
            Column(modifier = Modifier
                .background(colorResource(R.color.neutral_50))
                .padding(16.dp)
            ) {

                Spacer(modifier = Modifier.size(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                navController.navigate("miCuenta")
                            }
                            .size(20.dp)
                            .padding(end = 4.dp),
                        tint = colorResource(R.color.neutral_500)
                    )
                    Text(
                        text = "Dirección de envío",
                        style = MaterialTheme.typography.bodySmall.copy(color = colorResource(R.color.neutral_600))
                    )
                }

                Text(text = "Enrique Palacios 430, Miraflores",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall.copy(color = colorResource(R.color.neutral_500))
                )
            }

            Column(modifier = Modifier.background(colorResource(R.color.neutral_50))) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate("miCuenta")
                                }
                                .size(20.dp)
                                .padding(end = 4.dp),
                            tint = colorResource(R.color.neutral_500)
                        )
                        Text(
                            text = "Detalle de productos",
                            style = MaterialTheme.typography.bodySmall.copy(color = colorResource(R.color.neutral_600))
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Precio Total",
                        style = MaterialTheme.typography.bodySmall.copy(color = colorResource(R.color.neutral_500)),
                        textAlign = TextAlign.End
                    )
                }
                ItemProductCart()
                ItemProductCart()
            }

            Spacer(modifier = Modifier.size(10.dp))

            Column(modifier = Modifier.background(colorResource(R.color.neutral_50))) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = null,
                            modifier = Modifier
                                .clickable {
                                    navController.navigate("miCuenta")
                                }
                                .size(20.dp)
                                .padding(end = 4.dp),
                            tint = colorResource(R.color.neutral_500)
                        )
                        Text(
                            text = "Seleccione el tipo de envío",
                            style = MaterialTheme.typography.bodySmall.copy(color = colorResource(R.color.neutral_600))
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Precio Total",
                        style = MaterialTheme.typography.bodySmall.copy(color = colorResource(R.color.neutral_500)),
                        textAlign = TextAlign.End
                    )
                }
                ItemProductDelivery(
                    deliveryType = "Regular",
                    deliveryTime = "7 días hábiles",
                    price = "Gratis",
                    imageResId = R.drawable.regular
                )
                ItemProductDelivery(
                    deliveryType = "Express",
                    deliveryTime = "3 días hábiles",
                    price = "$15.90",
                    imageResId = R.drawable.express
                )
                ItemProductDelivery(
                    deliveryType = "Turbo",
                    deliveryTime = "Al día siguiente",
                    price = "$30",
                    imageResId = R.drawable.rappy
                )
            }
        }
    }
}