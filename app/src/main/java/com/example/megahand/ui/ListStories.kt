package com.example.megahand.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.megahandapp.R

@Composable
fun Stories(
    storiesImage: String,
    storiesText: String
){
    Box(
        modifier = Modifier
            .size(92.dp)
            .border(width = 1.dp, color = Color(0xFFE7D52F), shape = RoundedCornerShape(8.dp))
    ){
        AsyncImage(
            model = storiesImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(0f),
                            Color(0xFFE7D52F).copy(0.3f),
                            Color(0xFFE7D52F).copy(0.4f),
                            Color(0xFFE7D52F).copy(0.5f),
                            Color(0xFF46423E).copy( 1f)
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    ),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.BottomStart
        ){
            Text(
                text = storiesText,
                fontSize = 10.sp,
                color = Color.White,
                lineHeight = 12.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
                modifier = Modifier
                    .padding(5.dp, 7.dp)
            )
        }
    }
}



@Preview
@Composable
fun StoriesPreview(){
    Stories( storiesImage = "",
        storiesText = ""
    )
}