package com.example.megahand.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.megahandapp.R
import kotlinx.coroutines.launch

@Composable
fun BottomBar(
    navController: NavHostController,
    sheetState: ModalBottomSheetState
) {

    BottomNavigation(
        backgroundColor = (Color.White),
    ) {
        val scope = rememberCoroutineScope()

        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route


        BottomNavItem(
            selected = currentRoute == "Main",
            onClick = { navController.navigate("Main")},
            image = ImageVector.vectorResource(R.drawable.home),
            text = "Главная",
        )
        BottomNavItem(
            selected = false,
            onClick = { },
            image = ImageVector.vectorResource(R.drawable.card),
            text = "Моя Карта",
        )
        BottomNavItem(
            selected = currentRoute == "Shop",
            onClick = { navController.navigate("Shop")},
            image = ImageVector.vectorResource(R.drawable.shop),
            text = "Магазины",
        )
        BottomNavItem(
            selected = false,
            onClick = { },
            image = ImageVector.vectorResource(R.drawable.account),
            text = "Профиль",
        )
        BottomNavItem(
            selected = false,
            onClick = { scope.launch { sheetState.show() }},
            image = ImageVector.vectorResource(R.drawable.other),
            text = "Другое",
        )
    }
}

@Composable
fun RowScope.BottomNavItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    selected: Boolean,
    image: ImageVector,
    text: String
) {

    BottomNavigationItem(
        selected = selected,
        onClick = { onClick() },
        icon = {
            Icon(
                imageVector = image,
                contentDescription = null,
                tint = Color(0xFF46423E)
            )
        },
        label = {
            Text(
                text = text,
                fontSize = 10.sp,
                color = Color(0xFF46423E),
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
            )
        },
        alwaysShowLabel = true,
        modifier = Modifier
            .border(
                width = if (selected) 1.dp else 0.dp,
                color = if (selected) Color(0xFFE7D52F) else Color.White,
                shape = RoundedCornerShape(
                    topEnd = 8.dp,
                    topStart = 8.dp,
                    bottomStart = 16.dp,
                    bottomEnd = 8.dp
                )
            )
    )
}