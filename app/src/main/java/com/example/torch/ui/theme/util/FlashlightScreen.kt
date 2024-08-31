package com.example.torch

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.torch.ui.theme.util.BannerAd

@Composable
fun FlashlightScreen(
    modifier: Modifier = Modifier,
    onToggleFlashlight: (Boolean) -> Unit,
    onAdjustBrightness: (Int) -> Unit
) {
    var sliderPosition by remember { mutableStateOf(0f) }
    var isFlashlightOn by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BannerAd(adText = "Top Banner Ad")

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                isFlashlightOn = !isFlashlightOn
                onToggleFlashlight(isFlashlightOn)
            }) {
                Text(text = if (isFlashlightOn) "Turn Off Flash" else "Turn On Flash")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Adjust Brightness")

            Slider(
                value = sliderPosition,
                onValueChange = { newValue ->
                    sliderPosition = newValue
                    onAdjustBrightness(newValue.toInt())
                },
                valueRange = 0f..3f,
                steps = 3
            )
        }

        BannerAd(adText = "Bottom Banner Ad")
    }
}

@Preview(showBackground = true)
@Composable
fun FlashlightScreenPreview() {
    FlashlightScreen(onToggleFlashlight = {}, onAdjustBrightness = {})
}
