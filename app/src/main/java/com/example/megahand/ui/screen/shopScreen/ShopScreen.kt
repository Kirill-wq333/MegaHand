package com.example.megahand.ui.screen.shopScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import com.example.megahand.ui.Header
import com.example.megahandapp.R


@Composable
fun ShopScreen(
    navController: NavHostController
){
    androidx.compose.material.Scaffold(
        topBar = {
            Header(
                nameCategory = stringResource(R.string.shop),
                icon = ImageVector.vectorResource(R.drawable.chevron_left),
                chevronLeftOnClick = {navController.navigate("Main")}
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {}
    }
}

