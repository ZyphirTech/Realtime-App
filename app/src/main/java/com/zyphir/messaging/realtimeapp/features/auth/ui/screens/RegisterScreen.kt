package com.zyphir.messaging.realtimeapp.features.auth.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun RegisterScreen(phone: String, onSubmit: (String, String) -> Unit) {
    var nick by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(phone)
            TextField(value = nick, onValueChange = { nick = it }, label = { Text("Nombre") })
            TextField(value = pass, onValueChange = { pass = it }, label = { Text("Contraseña") })
            Button(onClick = { onSubmit(nick, pass) }) {
                Text("Crear Cuenta")
            }
        }
    }
}