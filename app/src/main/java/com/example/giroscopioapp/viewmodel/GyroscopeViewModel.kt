
package com.example.giroscopioapp.viewmodel

import android.app.Application
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.math.sqrt

data class GyroscopeUiState(
    val rotationX: Float = 0f,
    val rotationY: Float = 0f,
    val rotationZ: Float = 0f
)

class GyroscopeViewModel(application: Application) : AndroidViewModel(application), SensorEventListener {

    private val sensorManager: SensorManager = application.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val gyroscope: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

    private val _uiState = MutableStateFlow(GyroscopeUiState())
    val uiState: StateFlow<GyroscopeUiState> = _uiState.asStateFlow()

    private var timestamp: Long = 0
    private val ns2s = 1.0f / 1000000000.0f
    private val rotation = floatArrayOf(0f, 0f, 0f)

    init {
        startGyroscope()
    }

    private fun startGyroscope() {
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_GAME)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_GYROSCOPE) {
            if (timestamp != 0L) {
                val dT = (event.timestamp - timestamp) * ns2s
                rotation[0] += event.values[0] * dT
                rotation[1] += event.values[1] * dT
                rotation[2] += event.values[2] * dT

                _uiState.value = GyroscopeUiState(
                    rotationX = rotation[0] * 180 / Math.PI.toFloat(),
                    rotationY = rotation[1] * 180 / Math.PI.toFloat(),
                    rotationZ = rotation[2] * 180 / Math.PI.toFloat()
                )
            }
            timestamp = event.timestamp
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // No es necesario para este ejemplo
    }

    override fun onCleared() {
        super.onCleared()
        sensorManager.unregisterListener(this)
    }
}
