package com.example.appinmunocal.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.appinmunocal.R

@Composable
fun MicuentaView (navController: NavController) {
    Box(contentAlignment = Alignment.TopCenter,
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    )
    {
        Box () {
            Image(painter = painterResource(id = R.drawable.fondo_tercera_pantalla), contentDescription = "",contentScale = ContentScale.FillBounds, modifier = Modifier
                .width(420.dp)
                .height(200.dp)
                .align(alignment = Alignment.TopStart)
            )

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = colorResource(id = R.color.neutral_50),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .padding(start = 20.dp, top = 60.dp)
            )
        }

        Column (modifier = Modifier.padding(5.dp)){

            Text(text = "Mi Cuenta", style = MaterialTheme.typography.titleLarge, fontSize = 30.sp, color = colorResource(
                id = R.color.neutral_200
            ), modifier = Modifier
                .align(Alignment.Start)
                .padding(85.dp))

            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
            ){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null, modifier = Modifier.size(130.dp))
                Text(text = "Jean G. De la Cruz M.")
            }

            Spacer(modifier = Modifier.height(40.dp))

            Column (verticalArrangement = Arrangement.Bottom, modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .clip(RoundedCornerShape(30.dp))
                .background(colorResource(id = R.color.neutral_600))
                .padding(15.dp)
            ) {
                Image(painter = painterResource(id = R.drawable.rectangle_linea), contentDescription = "", modifier = Modifier
                    .width(100.dp)
                    .height(10.dp)
                    .align(Alignment.CenterHorizontally))

                Spacer(modifier = Modifier.height(5.dp))

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("detail_perfil")
                    }) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "", modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(
                            colorResource(id = R.color.neutral_200)
                        ))
                    Text(text = "        Mi Perfil", style = MaterialTheme.typography.titleSmall,
                        color = colorResource(id = R.color.neutral_200),
                        modifier = Modifier.padding(start = 30.dp))
                }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("myShops")
                    }) {
                    Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "", modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(
                            colorResource(id = R.color.neutral_200)
                        ))
                    Text(text = "        Mi Orden", style = MaterialTheme.typography.titleSmall,
                        color = colorResource(id = R.color.neutral_200),
                        modifier = Modifier.padding(start = 30.dp))
                }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("detail_perfil")
                    }) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "", modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(
                            colorResource(id = R.color.neutral_200)
                        ))
                    Text(text = "        Pagos", style = MaterialTheme.typography.titleSmall,
                        color = colorResource(id = R.color.neutral_200),
                        modifier = Modifier.padding(start = 30.dp))
                }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("suscripciones")
                    }) {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "", modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(
                            colorResource(id = R.color.neutral_200)
                        ))
                    Text(text = "        Suscripciones", style = MaterialTheme.typography.titleSmall,
                        color = colorResource(id = R.color.neutral_200),
                        modifier = Modifier.padding(start = 30.dp))
                }
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("cupones")
                    }) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = "", modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(
                            colorResource(id = R.color.neutral_200)
                        )
                    )
                    Text(text = "        Cupones", style = MaterialTheme.typography.titleSmall,
                        color = colorResource(id = R.color.neutral_200),
                        modifier = Modifier.padding(start = 30.dp))
                }

                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate("notificaciones")
                    }) {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = "", modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape)
                        .background(
                            colorResource(id = R.color.neutral_200)
                        ))
                    Text(text = "        Notificaciones", style = MaterialTheme.typography.titleSmall,
                        color = colorResource(id = R.color.neutral_200),
                        modifier = Modifier.padding(start = 30.dp))
                }

            }
        }



    }
}


@Preview(showBackground = true)
@Composable
fun PreviewComponente3() {
    val navController = rememberNavController()
    MicuentaView(navController = navController)
}