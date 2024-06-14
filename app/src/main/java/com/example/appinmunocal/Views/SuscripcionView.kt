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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.appinmunocal.R

@Composable
fun SuscripcionView(navController: NavHostController) {
    Scaffold (
        topBar = { barraSuperiorSub(navController)},
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){
                SuscripcionViewContent(navController)
            }
        },
        bottomBar = { barraInferior(navController)}
    )
}

@Composable
fun SliderBox(navController: NavController) {
    val listState = rememberLazyListState()
    val items = listOf("Semuno Plus", "AnualFord", "Triuno")
    val price = listOf("S/. 315","S/. 291.67", "S/. 315")
    val focusColor = colorResource(R.color.primary_500)
    val unfocusedColor = colorResource(R.color.primary_300)

    LazyRow(state = listState) {
        items(items.size) { index ->
            val isInFocus = index == listState.firstVisibleItemIndex + 1
            Box(
                modifier = Modifier
                    .width(180.dp)
                    .height(250.dp)
                    .padding(8.dp)
                    .background(
                        if (isInFocus) focusColor else unfocusedColor,
                        RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.inmunox2),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(y = (-200).dp)
                        .clip(RoundedCornerShape(8.dp))
                        .zIndex(3f)
                )
                Column {
                    Text(items[index],
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(R.color.neutral_700)
                    )

                    Text("Duración: 12 meses",
                        style = MaterialTheme.typography.labelSmall,
                        color = colorResource(R.color.neutral_600)
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Text(price[index],
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.bodyLarge,
                        color = colorResource(R.color.accent)
                    )
                    Text("Por mes", style = MaterialTheme.typography.displaySmall)
                    Spacer(modifier = Modifier.size(20.dp))
                    Button(
                        onClick = { navController.navigate("detail_sub")
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.secondary_600)),
                        modifier = Modifier
                    ) {
                        Text("Ver mas",
                            style = MaterialTheme.typography.labelSmall.copy(color = Color.DarkGray)
                        )
                        Icon(imageVector = Icons.Default.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                .padding(0.dp),
                            tint = Color.DarkGray
                        )
                    }
                    Spacer(modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraSuperiorSub(navController: NavHostController) {
    TopAppBar(
        modifier = Modifier,
        title = { Text("Elige el plan ideal para ti") },
        navigationIcon = {
            IconButton(onClick = {navController.navigate("micuenta")}) {
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
fun SuscripcionViewContent(navController: NavController){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Image(painter = painterResource(R.drawable.circle_back ) , contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .width(300.dp)
                .size(320.dp)
                .align(Alignment.TopCenter))
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.size(75.dp))
            Row (modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            )
            {
                SliderBox(navController = navController)
            }

            Image(
                painter = painterResource(id = R.drawable.pack),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )

            Text(
                text = "Fortalece el Sistema Inmunológico* Al aumentar la producción de glutatión, puede fortalecer las defensas de tu cuerpo*",
                style = MaterialTheme.typography.labelSmall.copy(color = colorResource(R.color.neutral_600)
                    ,textAlign = TextAlign.Center,),
                modifier = Modifier
                    .width(280.dp)
            )
        }
    }
}
