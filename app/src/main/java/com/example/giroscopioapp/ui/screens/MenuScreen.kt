package com.example.giroscopioapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.giroscopioapp.ui.components.InfoCard
import com.example.giroscopioapp.viewmodel.MenuViewModel

@Composable
fun MenuScreen(viewModel: MenuViewModel, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.padding(30.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            InfoCard(
                "Carriola",
                "Carriolas en descuento",
                Modifier.weight(1f)
                    .clickable { viewModel.goToCarriola(navController) },
                viewModel
            )
        }
        Row(modifier = Modifier.fillMaxWidth()){
            InfoCard(
                "Ropa",
                "Ropa para todos los meses",
                Modifier.weight(1f)
                    .clickable{viewModel.goToRopa(navController)},
                viewModel
            )}
        Row(modifier = Modifier.fillMaxWidth()){
            InfoCard(
                "Accesorio",
                "Accesorio para bebes",
                Modifier.weight(1f)
                    .clickable{viewModel.goToAccesorio(navController)},
                viewModel
            )

        }
    }
}