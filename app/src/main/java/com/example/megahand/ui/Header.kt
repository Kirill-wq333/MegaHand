package com.example.megahandapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.megahandapp.R



@Composable
fun Header(
    nameCategory: String,
    icon: ImageVector,
    chevronLeftOnClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color.White
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier
                        .height(24.dp)
                        .clickable { chevronLeftOnClick() }
                )
                Text(
                    text = nameCategory,
                    fontSize = 20.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_bold))),
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Row(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = Color(0xFF46423E).copy(0.1f),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(
                                color = Color(0xFFE7D52F),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.surprisebox),
                            contentDescription = null
                        )
                    }
                    Text(
                        text = "7200Р",
                        fontSize = 14.sp,
                        color = Color(0xFF46423E),
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold))),
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.location),
                        contentDescription = null
                    )
                    Image(
                        painter = painterResource(R.drawable.notifications),
                        contentDescription = null
                    )
                }
            }
        }
    }
}