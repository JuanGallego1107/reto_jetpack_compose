package com.apps_moviles.taller_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.apps_moviles.taller_kotlin.ui.theme.Taller_kotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller_kotlinTheme{
                ContadorSecretoApp()
            }
        }
    }
}

@Composable
fun ContadorSecretoApp() {
    // Estado para almacenar el número de clics
    var contador by remember { mutableStateOf(0) }

    // Número secreto
    val numeroSecreto = 11

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Muestra intentos / numero secreto
        if (contador < numeroSecreto) {
            Text(
                text = "Intentos: $contador",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary
            )
        } else {
            Text(
                text = "¡Descubriste el número secreto! $numeroSecreto",
                fontSize = 26.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Oculta boton si se descubre el numero secreto
        if(contador < numeroSecreto) {
            // Botón
            Button(
                onClick = {
                    // Incrementa contador hasta llegar al número secreto
                    if (contador < numeroSecreto) contador++
                }
            ) {
                Text("Presióname", fontSize = 20.sp)
            }
        }
    }
}
