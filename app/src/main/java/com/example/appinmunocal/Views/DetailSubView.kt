package com.example.appinmunocal.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AlertDialog
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.appinmunocal.R

@Composable
fun DetailSubView(navController: NavHostController) {
    Scaffold (
        topBar = { barraSuperiorSubDetail(navController)},
        content = {reservado ->
            Surface(modifier = Modifier.padding(reservado)){
                DetailSubViewContent(navController)
            }
        },
        bottomBar = { barraInferior(navController)}
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun barraSuperiorSubDetail(navController: NavHostController) {
    TopAppBar(
        modifier = Modifier,
        title = { Text("AnualFort") },
        navigationIcon = {
            IconButton(onClick = {navController.navigate("suscripciones")}) {
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
//@Preview(showBackground = true)
fun DetailSubViewContent(navController: NavHostController){

    val openDialog = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(R.drawable.circle_back ) , contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .width(330.dp)
                .size(320.dp)
                .align(Alignment.TopCenter))
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally){
            Spacer(modifier = Modifier.size(30.dp))
            Image(
                painter = painterResource(id = R.drawable.anualfort),
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.size(80.dp))
            Text("Lo que obtienes con el plan",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "1 Immunocal, 1 Immunocal Sport, 1 Immunocal Optimizer ¡GRATIS!\n" +
                        "Más de 1500 cursos y 17 escuelas\n" +
                        "Certificados digitales\n" +
                        "Certificados físicos para rutas de perfil profesional\n" +
                        "English Academy, Escuela de Startups, Liderazgo y Management",
                style = MaterialTheme.typography.labelSmall.copy(color = colorResource(R.color.neutral_600)
                    ,textAlign = TextAlign.Center,),
                modifier = Modifier
                    .width(280.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Button(
                onClick = { openDialog.value = true },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.primary_600)),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Suscríbete")
            }
            if (openDialog.value) {
                AlertDialog(
                    onDismissRequest = { openDialog.value = false },
                    title = { Text(text = "¡Felicitaciones!") },
                    text = { Text("Your monthly meal plan subscription has been set successfully.") },
                    confirmButton = {
                        Button(
                            onClick = { navController.navigate("home") },
                            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.primary_600)),
                            modifier = Modifier
                                .width(200.dp)
                                .align(Alignment.CenterHorizontally)
                        ) {
                            Text("Regresar al inicio",
                                style = MaterialTheme.typography.labelSmall,
                                color = colorResource(R.color.neutral_50)
                            )
                        }
                    }
                )
            }
        }
    }
}