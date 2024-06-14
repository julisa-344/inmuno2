package com.example.appinmunocal.Views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appinmunocal.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsView(
    categorias: List<Categoria>,
    productos: List<Producto>,
    cantidadEnCarrito: Int,
    onRegresarClicked: () -> Unit,
    onCarritoClicked: () -> Unit,
    onAgregarAlCarrito: (Producto) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){
        Column {
            TopAppBar(
                title = { Text("") },
                navigationIcon = {
                    IconButton(onClick = { onRegresarClicked() },  modifier = Modifier.size(30.dp).align(
                        Alignment.Start)) {
                        Icon(
                            Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Regresar",
                            modifier = Modifier.size(40.dp))
                    }
                },
                actions = {
                    val textoBusqueda = remember { mutableStateOf("") }

                    val customTextFieldStyles = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        disabledLabelColor = Color.Gray,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )

                    // Modifier para aplicar a nuestro TextField
                    val customModifier = Modifier
                        .padding(8.dp)
                        .background(
                            colorResource(id = R.color.neutral_200),
                            RoundedCornerShape(10.dp)
                        )


                    TextField(
                        value = textoBusqueda.value,
                        onValueChange = { nuevoValor -> textoBusqueda.value = nuevoValor },
                        modifier = customModifier,
                        colors = customTextFieldStyles,
                        leadingIcon = { Icon(Icons.Filled.Search, tint = colorResource(id = R.color.neutral_500) ,contentDescription = "Buscar") },
                        placeholder = { Text("Buscar...", color = colorResource(id = R.color.neutral_500)) },
                        singleLine = true
                    )
                    Badge(containerColor = Color.Transparent, modifier = Modifier.size(30.dp)) {
                        IconButton(onClick = { onCarritoClicked() }) {
                            Icon(
                                Icons.Default.ShoppingCart,
                                contentDescription = "Carrito")
                            Text("$cantidadEnCarrito")
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.size(16.dp))

            LazyRow(modifier = Modifier.padding(8.dp)) {
                items(categorias.size) { index ->
                    CategoriaItem(categorias[index])
                }
            }
            ListaProductos(productos, onAgregarAlCarrito)
            ListaProductos(productos, onAgregarAlCarrito)
        }
    }
}




@Composable
fun CategoriaItem(categoria: Categoria) {
    Card(modifier = Modifier
        .padding(horizontal = 16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(color = colorResource(id = R.color.neutral_50), RoundedCornerShape(10.dp))
        ) {
            Image(painter = painterResource(id = R.drawable.salud),
                contentDescription = categoria.nombre,
                Modifier.size(50.dp))
            Text(categoria.nombre,
                style = MaterialTheme.typography.labelMedium,
                color = colorResource(R.color.neutral_600),
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun ListaProductos(productos: List<Producto>, onAgregarAlCarrito: (Producto) -> Unit) {
    val gridState = rememberLazyGridState()
    val columnas = GridCells.Fixed(2)

    LazyVerticalGrid(
        columns = columnas,
        state = gridState,
        contentPadding = PaddingValues(8.dp),
        content = {
            items(productos.size) { index ->
                ProductoItem(productos[index], onAgregarAlCarrito)
            }
        }
    )
}

@Composable
fun ProductoItem(producto: Producto, onAgregarAlCarrito: (Producto) -> Unit) {
    Card(modifier = Modifier.padding(4.dp)) {
        Box(modifier = Modifier
            .background(color = colorResource(id = R.color.neutral_50), RoundedCornerShape(10.dp))
            .height(240.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(2.dp),
                ambientColor = colorResource(id = R.color.neutral_300),
                spotColor = colorResource(id = R.color.neutral_400),
            )
        )
        {
            Column(
                modifier = Modifier
                    .padding(26.dp)
                    .fillMaxSize(),
            )
            {
                Image(painter = painterResource(id = R.drawable.inmunox2),
                    contentDescription = producto.nombre,
                    modifier = Modifier
                        .size(100.dp)
                        .align(Alignment.CenterHorizontally))
                Text(producto.nombre,
                    style = MaterialTheme.typography.labelMedium,
                    color = colorResource(R.color.neutral_600),
                    fontWeight = FontWeight.Bold,

                    )
                Text("Precio: $100",
                    style = MaterialTheme.typography.labelSmall,
                    color = colorResource(R.color.primary_600),
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.size(10.dp))
                IconButton(
                    onClick = { onAgregarAlCarrito(producto) },
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = colorResource(id = R.color.primary_600),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .size(40.dp)
                        .background(
                            colorResource(id = R.color.neutral_50),
                            RoundedCornerShape(10.dp)
                        )
                        .align(Alignment.End)
                        .padding(8.dp)
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = "Agregar al carrito",
                        tint = colorResource(id = R.color.primary_600),
                        modifier = Modifier.size(24.dp)
                    )
                }

            }
        }
    }
}

// Define tus modelos de datos para categorías y productos
data class Categoria(val nombre: String, val imagenUrl: Int)
data class Producto(val nombre: String, val imagenUrl: Int)