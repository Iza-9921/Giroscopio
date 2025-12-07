package com.example.giroscopioapp.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.giroscopioapp.ui.screens.HomeScreen
import com.example.giroscopioapp.ui.screens.LoginScreen
import com.example.giroscopioapp.ui.screens.MenuScreen
import com.example.giroscopioapp.ui.screens.RegisterScreen
import com.example.giroscopioapp.viewmodel.LoginViewModel
import com.example.giroscopioapp.viewmodel.MenuViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            val vm: LoginViewModel = viewModel()
            LoginScreen(viewModel = vm, navController = navController)
        }
        composable("register") {
            RegisterScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }

        composable("menu") {
            val vm: MenuViewModel = viewModel()
            MenuScreen(viewModel = vm, navController = navController)
        }
    }
}
