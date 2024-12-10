package com.example.megahandapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.megahandapp.R


@Composable
fun LoadingScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF46423E)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(169.dp)
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.logo_minimized),
                contentDescription = null
            )
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(28.dp),
                strokeWidth = 3.dp,
                color = Color(0xFFE7D52F)
            )
        }
    }
}



@Preview
@Composable
fun LoadingScreenPreview() {
    LoadingScreen()
}