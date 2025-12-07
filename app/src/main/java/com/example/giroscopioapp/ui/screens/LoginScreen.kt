package com.example.giroscopioapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.giroscopioapp.R
import com.example.giroscopioapp.ui.components.buttons.PrimaryButton
import com.example.giroscopioapp.ui.components.images.CircularImage
import com.example.giroscopioapp.ui.components.inputs.PasswordField
import com.example.giroscopioapp.ui.components.inputs.UserInputField
import com.example.giroscopioapp.ui.components.texts.Link
import com.example.giroscopioapp.ui.components.texts.Title
import com.example.giroscopioapp.ui.theme.GiroscopioAppTheme
import com.example.giroscopioapp.viewmodel.LoginViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        // Cambio mínimo: arrancar el contenido arriba para que la imagen y el título siempre se vean
        verticalArrangement = Arrangement.Top
    ) {
        // Pedir tamaño explícito (tu CircularImage ya acepta `size: Int`)
        CircularImage(R.drawable.gemini_generated_image_pjhj4ipjhj4ipjhj, size = 120)
        Spacer(modifier = Modifier.height(8.dp))

        // Aseguramos que el Title tenga ancho para mostrarse correctamente
        Title("GIRIOSCOPIO", fontSize = 22, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(18.dp))

        UserInputField(viewModel = viewModel, label = "Usuario")
        Spacer(modifier = Modifier.height(12.dp))
        PasswordField(viewModel = viewModel, label = "Contraseña")

        if (viewModel.loginError.value.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = viewModel.loginError.value,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        PrimaryButton(
            text = "Iniciar sesion",
            onClick = {
                viewModel.login {
                    navController.navigate("menu") {
                        popUpTo("login") { inclusive = true }
                    }
                }
            },
            // hacemos botón ancho y con altura razonable
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Link("¿Has olvidado la contraseña?") {
                navController.navigate("forgot_password")
            }
            Link("Regístrate") {
                navController.navigate("register")
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    GiroscopioAppTheme {
        val navController = rememberNavController()
        val viewModel = LoginViewModel()
        LoginScreen(viewModel, navController)
    }
}
