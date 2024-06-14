package com.example.appinmunocal.Views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.appinmunocal.R

@Composable
fun HomeView(navController: NavHostController) {
    Scaffold (
        topBar = { barraSuperiorHome(navController)},
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){
                HomeViewContent(navController)
            }
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraSuperiorHome(navController: NavHostController) {
    TopAppBar(
        modifier = Modifier,
        title = { Text("Carrito de compras") },
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
fun HomeViewContent(navController: NavHostController){
    var text = ""

    Box(contentAlignment = Alignment.TopCenter,
        modifier = Modifier.fillMaxSize()
            .clickable {
                navController.navigate("products")
            }){
        Column (horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 15.dp)){


            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(  painter = painterResource(
                    id =   R.drawable.logo
                ),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = "Productos",
                    style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
                    color = Color.White)
            }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)) {
                TextField(value = text, onValueChange = { newText -> text = newText},
                    modifier = Modifier
                        .height(10.dp)
                        .background(Color.White, shape = RoundedCornerShape(30)),
                    label = { Text("Ingrese su texto") })
                Spacer(modifier = Modifier.width(10.dp))
                Icon(imageVector = Icons.Default.Notifications, contentDescription = "campana",
                    modifier = Modifier.size(30.dp), tint = Color.White)
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "cara",
                    modifier = Modifier.size(30.dp), tint = Color.White)
            }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .background(color = Color(0xFFffca99), shape = RoundedCornerShape(16.dp))
                    .padding(15.dp)
            ) {
                Column(modifier = Modifier) {
                    Text("Descuento", color = Color.White, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
                    Text("20%", color = Color.White, style = TextStyle(fontSize = 50.sp, fontWeight = FontWeight.Bold))
                    Text("Immunocal sport", color = Color.White)
                    Spacer(modifier = Modifier.height(30.dp))

                    Button(onClick = { navController.navigate("producto")}) {
                        Text("Detalles")
                    }
                }
                Spacer(modifier = Modifier.width(30.dp))
                Image(painter = painterResource(id = R.drawable.immunocal_optimizer), contentDescription = null,
                    modifier = Modifier.size(150.dp))

            }
            Spacer(modifier = Modifier.height(15.dp))



            Column (modifier = Modifier
                .background(Color.White)
                .padding(15.dp)){
                Box(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()){
                    Text(text = "Categorias", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold))
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                    horizontalArrangement = Arrangement.spacedBy(40.dp)) {
                    Column(modifier = Modifier) {
                        Image(painter = painterResource(id = R.drawable.bienestar),
                            contentDescription = "Imagen",
                            modifier = Modifier.size(width = 50.dp, height = 50.dp),contentScale = ContentScale.FillBounds)

                        Text(text = "Bienestar", style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }
                    Column(modifier = Modifier) {
                        Image(painter = painterResource(id = R.drawable.alimentacion),
                            contentDescription = "Imagen",
                            modifier = Modifier.size(width = 50.dp, height = 50.dp),contentScale = ContentScale.FillBounds)

                        Text(text = "Alimentación", style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }
                    Column(modifier = Modifier) {
                        Image(painter = painterResource(id = R.drawable.condicionfisica),
                            contentDescription = "Imagen",
                            modifier = Modifier.size(width = 50.dp, height = 50.dp),contentScale = ContentScale.FillBounds)

                        Text(text = "Ejercicio", style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }
                    Column(modifier = Modifier) {
                        Image(painter = painterResource(id = R.drawable.apariencia),
                            contentDescription = "Imagen",
                            modifier = Modifier.size(width = 50.dp, height = 50.dp),contentScale = ContentScale.FillBounds)

                        Text(text = "Apariencia", style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }
                }


                Divider(modifier = Modifier.padding(vertical = 8.dp), color = Color.DarkGray)

                Box(modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()){
                    Text(text = "Precios Especiales", style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold))
                }
                Row(modifier = Modifier) {
                    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painter = painterResource(id = R.drawable.immunocal_original), contentDescription = null,
                            modifier = Modifier.size(80.dp))
                        Text(text = "S/. 250.00", style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painter = painterResource(id =  R.drawable.immunocal_platinum), contentDescription = null,
                            modifier = Modifier.size(80.dp))
                        Text(text = "S/. 350.00", style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painter = painterResource(id =  R.drawable.immunocal_energizer), contentDescription = null,
                            modifier = Modifier.size(80.dp))
                        Text(text = "S/. 150.00", style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    Column(modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painter = painterResource(id =  R.drawable.immunocal_optimizer), contentDescription = null,
                            modifier = Modifier.size(80.dp))
                        Text(text = "S/. 120.00", style = TextStyle(fontSize = 10.sp, fontWeight = FontWeight.SemiBold))
                    }


                }
            }


        }



    }
}