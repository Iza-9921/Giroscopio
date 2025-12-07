package com.example.giroscopioapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.giroscopioapp.R
import com.example.giroscopioapp.ui.components.buttons.PrimaryButton
import com.example.giroscopioapp.ui.components.images.CircularImage
import com.example.giroscopioapp.ui.components.texts.Title

@Composable
fun RegisterScreen(navController: NavController) {
    // estados del formulario
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        // mismo ajuste: empezar arriba
        verticalArrangement = Arrangement.Top
    ) {
        CircularImage(R.drawable.gemini_generated_image_pjhj4ipjhj4ipjhj, size = 120)
        Spacer(modifier = Modifier.height(8.dp))
        Title("Registro", fontSize = 20, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(12.dp))

        // Usuario
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Nombre") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        //apellido
        TextField(
            value = apellido,
            onValueChange = { apellido = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Apellido") },
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Correo
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Correo electronico") },
            placeholder = { Text("ejemplo@correo.com") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Contraseña") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Confirmar contraseña") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(12.dp))

        PrimaryButton(
            text = "Registrarse",
            onClick = { /* lógica de registro */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))
        PrimaryButton(
            text = "Volver al Login",
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
        )
    }
}
