package com.example.megahand.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil3.compose.AsyncImage
import com.example.megahandapp.R

@Composable
fun Collection(
    collectionImage: List<String>
) {
    Box(
        modifier = Modifier
            .width(300.dp)
            .height(180.dp),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = collectionImage,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
        )
    }
}
@Composable
fun BottomCollection(
    navController: NavHostController
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    Row(
        horizontalArrangement = Arrangement.Center
    ) {
        Collections(
            text = stringResource(R.string.collection_girl),
            isSelected = currentRoute == "Girl",
            onSelect = {navController.navigate("Girl")}
        )
        Collections(
            text = stringResource(R.string.collection_man),
            isSelected = currentRoute == "Man",
            onSelect = {navController.navigate("Man")}
        )
        Collections(
            text = stringResource(R.string.collection_children),
            isSelected = currentRoute == "Children",
            onSelect = {navController.navigate("Children")}
        )
    }
}

@Composable
fun Collections(
    modifier: Modifier = Modifier,
    text: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    val borderColor =
        if (isSelected) Color(0xFFE7D52F) else Color(0xFF46423E).copy(0.05f)
    val colorText =
        if (isSelected) Color(0xFF46423E) else Color(0xFF46423E).copy(0.4f)

    Box(
        modifier = modifier
            .width(120.dp)
            .height(30.dp)
            .border(
                width = 1.dp,
                color = borderColor,
            )
            .clickable(onClick = onSelect),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = colorText,
            fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold))),
            fontWeight = FontWeight.SemiBold
        )
    }
}


