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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appinmunocal.R

@Composable
fun MyShops(navController: NavHostController) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Recibidos", "Cancelados")

    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.neutral_100))
        .verticalScroll(rememberScrollState())
    )
    {
        Column {
            Row(modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(R.color.neutral_50))
                .padding(top = 16.dp)


            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("miCuenta")
                        }
                        .size(30.dp)
                        .padding(0.dp),
                    tint = colorResource(R.color.primary_600),

                    )
                Text(
                    text = "Mis ordenes",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium.copy(color = colorResource(R.color.primary_600))
                )
            }
            TabRow(
                selectedTabIndex = selectedTabIndex,
                Modifier.background(colorResource(R.color.primary_600)),
                contentColor = colorResource(R.color.primary_600)
            ) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title) },
                        selectedContentColor =  colorResource(R.color.primary_600),
                        unselectedContentColor =  colorResource(R.color.neutral_400),
                    )
                }
            }
            when (selectedTabIndex) {
                0 -> CompletadosView()
                1 -> CanceladosView()
            }
        }
    }
}

@Composable
fun ItemProduct(
    deliveryDate: String,
    orderCode: String,
    productName: String,
    quantity: String,
    price: String,
    imageResId: Int,
    totalItems: String,
    totalPrice: String
) {
    Spacer(modifier = Modifier.size(10.dp))
    Column(modifier = Modifier.background(colorResource(R.color.neutral_50))) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Delivery el $deliveryDate",
                style = MaterialTheme.typography.labelSmall,
                color = colorResource(R.color.neutral_500),
                fontWeight = FontWeight.Thin
            )
            Text(
                text = orderCode,
                style = MaterialTheme.typography.labelSmall,
                color = colorResource(R.color.primary_600),
                fontWeight = FontWeight.Thin
            )
        }
        Divider()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 1.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .height(70.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = imageResId),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.size(30.dp))
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = productName,
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
                                text = "x $quantity",
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(R.color.neutral_500),
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Precio: $price",
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(R.color.primary_600),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
        Divider()
        Spacer(modifier = Modifier.size(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "$totalItems    |    $totalPrice",
                style = MaterialTheme.typography.labelSmall,
                color = colorResource(R.color.primary_600),
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "more info",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun CompletadosView() {
    Box {
        Column {
            ItemProduct(
                deliveryDate = "16.07.2022, 20:53",
                orderCode = "M2Z4-VVY2",
                productName = "Inmunox",
                quantity = "1",
                price = "S/. 234",
                imageResId = R.drawable.inmunox2,
                totalItems = "1 Item",
                totalPrice = " S/. 234"
            )
            ItemProduct(
                deliveryDate = "20.07.2020, 14:50",
                orderCode = "Y1E4-GHH6",
                productName = "Inmuno Energy",
                quantity = "2",
                price = "S/. 608",
                imageResId = R.drawable.immunocal_energizer,
                totalItems = "1 Item",
                totalPrice = " S/. 304"
            )
        }
    }
}

@Composable
fun CanceladosView() {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.cancelados), contentDescription = null)
            Text(
                text = "No tienes ordenes canceladas",
                style = MaterialTheme.typography.labelMedium,
                color = colorResource(R.color.neutral_500),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}