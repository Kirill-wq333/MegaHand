package com.example.megahand.ui.screen.citiesScreen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.megahandapp.R

@Composable
fun BlockItem(
    modifier: Modifier = Modifier,
    letter: String,
    onSelect: Boolean
) {

    Box(
        modifier = modifier
            .size(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = letter,
            fontSize = 14.sp,
            color = Color(0xFF46423E),
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
            modifier = modifier
                .border(
                    width = 1.dp,
                    color = if (onSelect) Color(0xFF46423E).copy(0.05f) else Color(0xFFE7D52F)
                    )
        )
    }

}