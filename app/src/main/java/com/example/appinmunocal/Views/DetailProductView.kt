package com.example.appinmunocal.Views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.appinmunocal.R
import kotlinx.coroutines.launch

@Composable
fun DetailProductosView(navController: NavHostController) {
    Scaffold (
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){
                DetailProductosViewContent(navController)
            }
        },
        bottomBar = { barraInferiorDetailP(navController)}
    )
}

@Composable
fun barraInferiorDetailP(navController: NavHostController){
    BottomAppBar {
        Row {
            IconButton(onClick = { navController.navigate("lista") }) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Retroceso")
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { navController.navigate("lista") }) {
                Icon(imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favoritos")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailProductosViewContent(navController: NavHostController){
    Box (
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ){
        Column(modifier = Modifier) {
            Box (modifier = Modifier.background(color = Color.Red).height(300.dp), ) {
                Image(painter = painterResource(id = R.drawable.immunocalsportt),
                    contentDescription = null,
                    modifier = Modifier
                        .size(450.dp)
                        .fillMaxWidth()
                )

                IconButton(onClick = { navController.navigate("products") },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopStart)) {
                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Retroceso",
                        tint = Color.White)
                }

                IconButton(onClick = { navController.navigate("lista") },
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopEnd)) {
                    Icon(imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Retroceso",
                        tint = Color.White)
                }
            }
            Column (modifier = Modifier.padding(15.dp)) {
                Text(text = "Immunocal Sport",
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorResource(id = R.color.neutral_700))
                Row {
                    Text(text = " S/. 374.25",
                        style = MaterialTheme.typography.bodyLarge,
                        color = colorResource(id = R.color.primary_600)
                    )
                    Text(text = " /caja",
                        style = MaterialTheme.typography.bodyLarge,
                        color = colorResource(id = R.color.primary_600)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = " S/. 499.00",
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(id = R.color.neutral_500)
                    )
                }
            }
            val pageState = rememberPagerState(
                pageCount = {2}
            )
            val coroutineScope = rememberCoroutineScope()

            TabRow(selectedTabIndex = pageState.currentPage) {
                Tab(text = { Text(text = "Descripción") },
                    selected = pageState.currentPage == 0,
                    onClick = {
                        coroutineScope.launch {
                            pageState.animateScrollToPage(0)
                        }
                    })
                Tab(text = { Text(text = "Datos Nutricionales") },
                    selected = pageState.currentPage == 1,
                    onClick = {
                        coroutineScope.launch {
                            pageState.animateScrollToPage(1)
                        }
                    })
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                when (pageState.currentPage) {
                    0 -> {
                        Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = colorResource(id = R.color.neutral_600),
                            modifier = Modifier.padding(32.dp))
                    }
                    1 -> {
                        Text("Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                            modifier = Modifier.padding(32.dp))
                    }
                }
            }
            Box(modifier = Modifier.padding(15.dp)){
                Text(text = "Productos Relacionados",
                    style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
                )
            }
            Row(modifier = Modifier.padding(15.dp))  {
                Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.immunocal_optimizer),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp))
                    Column {
                        Text(text = "Optimizer",
                            style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        )
                        Text(text = "S/. 209.25",
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                        )
                    }
                }
                Spacer(modifier = Modifier.width(30.dp))
                Row (modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
                    Image(painter = painterResource(id = R.drawable.immunocal_energizer),
                        contentDescription = null,
                        modifier = Modifier.size(80.dp))
                    Column {
                        Text(text = "Performance",
                            style = TextStyle(fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                        )
                        Text(text = "S/. 127.50",
                            style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold)
                        )
                    }
                }
            }
        }
    }
}
