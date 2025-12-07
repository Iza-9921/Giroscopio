package com.example.giroscopioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.giroscopioapp.ui.Navigation
import com.example.giroscopioapp.ui.theme.GiroscopioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GiroscopioAppTheme {
                Navigation()
            }
        }
    }
}
//GiroscopioAppTheme