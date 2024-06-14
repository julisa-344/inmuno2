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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appinmunocal.R

data class UserProfile(
    val name: String,
    val email: String,
    val subscription: String,
    val gender: String,
    val birthday: String,
    val phoneNumber: String
)

@Composable
fun DetailPerfilView(navController: NavHostController) {
    Scaffold (
        topBar = { barraSuperiorPerfil(navController)},
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){

                val userProfile = UserProfile(
                    name = "John Doe",
                    email = "john.doe@gmail.com",
                    subscription = "Premium",
                    gender = "Hombre",
                    birthday = "1985-10-15",
                    phoneNumber = "937 601 484"
                )
                DetailPerfilViewContent(userProfile, navController)}
        },
        bottomBar = { barraInferior(navController)}
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraSuperiorPerfil(navController: NavHostController) {
    TopAppBar(
        modifier = Modifier,
        title = { Text("Mi plan") },
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
fun DetailPerfilViewContent(userProfile: UserProfile, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.neutral_200))
    ) {
        Box(modifier = Modifier
            .background(
                color = colorResource(id = R.color.primary_600),
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = 16.dp,
                    bottomStart = 16.dp
                )
            )
            .fillMaxWidth()
            .height(100.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.size(50.dp))
            ProfileDetailItem(title = "Suscripción", value = userProfile.subscription)
            ProfileDetailItem(title = "Nombre", value = userProfile.name)
            ProfileDetailItem(title = "Email", value = userProfile.email)
            ProfileDetailItem(title = "Género", value = userProfile.gender)
            ProfileDetailItem(title = "Cumpleaños", value = userProfile.birthday)
            ProfileDetailItem(title = "Número", value = userProfile.phoneNumber)
        }
    }
}

@Composable
fun ProfileDetailItem(title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(color = colorResource(R.color.neutral_100)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = value,
            color = colorResource(id = R.color.neutral_500),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(16.dp)
        )
    }
}