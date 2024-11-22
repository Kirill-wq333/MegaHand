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


        BottomNavigationItem(
            selected = currentRoute == "Main",
            onClick = { navController.navigate("Main") },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.home),
                    contentDescription = null,
                    tint = Color(0xFF46423E)
                )
            },
            label = {
                Text(
                    text = "Главная",
                    fontSize = 10.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                )
            },
            alwaysShowLabel = true,
            modifier = Modifier
                .border(
                    width = if(currentRoute == "Main") 1.dp else 0.dp,
                    color = if(currentRoute == "Main") Color(0xFFE7D52F) else Color.White,
                    shape =  RoundedCornerShape(
                        topEnd = 8.dp,
                        topStart = 8.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 8.dp
                    )
                )
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.card),
                    contentDescription = null,
                    tint = Color(0xFF46423E)
                )
            },
            label = {
                Text(
                    text = "Моя карта",
                    fontSize = 10.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                )
            },
            alwaysShowLabel = true
        )
        BottomNavigationItem(
            selected = currentRoute == "Shop",
            onClick = { navController.navigate("Shop") },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.shop),
                    contentDescription = null,
                    tint = Color(0xFF46423E)
                )
            },
            label = {
                Text(
                    text = "Магазины",
                    fontSize = 10.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                )
            },
            alwaysShowLabel = true,
            modifier = Modifier
                .border(
                    width = if(currentRoute == "Shop") 1.dp else 0.dp,
                    color = if(currentRoute == "Shop") Color(0xFFE7D52F) else Color.White,
                    shape =  RoundedCornerShape(
                        topEnd = 8.dp,
                        topStart = 8.dp,
                        bottomStart = 16.dp,
                        bottomEnd = 8.dp
                    )
                )
        )
        BottomNavigationItem(
            selected = false,
            onClick = { },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.account),
                    contentDescription = null,
                    tint = Color(0xFF46423E)
                )
            },
            label = {
                Text(
                    text = "Профиль",
                    fontSize = 10.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                )
            },
            alwaysShowLabel = true,
        )
        BottomNavigationItem(
            selected = false,
            onClick = { scope.launch { sheetState.show() } },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.other),
                    contentDescription = null,
                    tint = Color(0xFF46423E)
                )
            },
            label = {
                Text(
                    text = "Другое",
                    fontSize = 10.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                )
            },
            alwaysShowLabel = true,
        )
        BottomNavItem(
            onClick = { navController.navigate("") }
        )
        BottomNavItem(
            onClick = { navController.navigate("") }
        )
        BottomNavItem(
            onClick = { navController.navigate("") }
        )
        BottomNavItem(
            onClick = { navController.navigate("") }
        )
        BottomNavItem(
            onClick = { scope.launch { sheetState.show()} }
        )
    }
}

@Composable
fun RowScope.BottomNavItem(
    modifier: Modifier = Modifier,
    // ...
    onClick: () -> Unit
) {

    BottomNavigationItem(
        selected = false,
        onClick = onClick,
        icon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.other),
                contentDescription = null,
                tint = Color(0xFF46423E)
            )
        },
        label = {
            Text(
                text = "Другое",
                fontSize = 10.sp,
                color = Color(0xFF46423E),
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
            )
        },
        alwaysShowLabel = true,
    )
}