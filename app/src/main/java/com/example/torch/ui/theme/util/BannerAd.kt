package com.example.torch.ui.theme.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BannerAd(modifier: Modifier = Modifier, adText: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)  // Set the height to 100 dp
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Text(text = adText, color = Color.White, style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun BannerAdPreview() {
    BannerAd(adText = "Sample Ad Banner")
}
