package com.example.giroscopioapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.giroscopioapp.viewmodel.GyroscopeViewModel

@Composable
fun GyroscopeScreen(gyroscopeViewModel: GyroscopeViewModel = viewModel()) {
    val uiState by gyroscopeViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mueve tu dispositivo", fontSize = 24.sp, modifier = Modifier.padding(bottom = 32.dp))

        // Esta es la caja que rotará
        Box(
            modifier = Modifier
                .size(150.dp)
                // Aquí aplicamos la rotación
                .graphicsLayer {
                    rotationX = uiState.rotationX
                    rotationY = uiState.rotationY
                    rotationZ = uiState.rotationZ
                }
                .background(Color.Cyan)
        )
    }
}
