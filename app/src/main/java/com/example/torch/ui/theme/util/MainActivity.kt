package com.example.torch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.torch.ui.theme.TorchTheme
import com.example.torch.ui.theme.util.FlashlightController

class MainActivity : ComponentActivity() {

    private lateinit var flashlightController: FlashlightController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        flashlightController = FlashlightController(this)

        setContent {
            TorchTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FlashlightScreen(
                        modifier = Modifier.padding(innerPadding),
                        onToggleFlashlight = { enable ->
                            flashlightController.toggleFlashlight(enable)
                        },
                        onAdjustBrightness = { level ->
                            flashlightController.setFlashlightBrightness(level)
                        }
                    )
                }
            }
        }
    }
}
