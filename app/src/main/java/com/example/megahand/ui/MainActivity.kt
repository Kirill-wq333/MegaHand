@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.megahandapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.megahandapp.ui.screen.ArticleScreen
import com.example.megahandapp.ui.screen.MainScreen
import com.example.megahandapp.ui.screen.NewScreen
import com.example.megahandapp.ui.screen.ServiceScreen
import com.example.megahandapp.ui.screen.ShopScreen
import com.example.megahand.ui.bottom.BottomBar
import com.example.megahand.ui.bottom.BottomSheet
import com.example.megahandapp.ui.theme.MegahandAppTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MegahandAppTheme {
                val scrollState = rememberScrollState()
                MegaHand(scrollState = scrollState)
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MegaHand(
    scrollState: ScrollState
) {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    val navController = rememberNavController()
    val sheetState = rememberModalBottomSheetState()

    Scaffold(
        bottomBar = { BottomBar(navController = navController, sheetState = sheetState) },
    ) { item ->
        Box(Modifier.padding(item)) {
            NavHost(
                startDestination = "Main",
                navController = navController
            ) {
                composable("Main") {
                    MainScreen(navController = navController)
                }
                composable("Shop") {
                    ShopScreen(navController = navController)
                }
                composable("News") {
                    NewScreen(navController = navController)
                }
                composable("Service") {
                    ServiceScreen(navController = navController)
                }
                composable("Article") {
                    ArticleScreen(navController = navController, scrollState = scrollState)
                }
            }
            if(openBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { openBottomSheet = false },
                    sheetState = sheetState,
                ) {
                    BottomSheet(
                        sheetState = sheetState,
                        navController = navController
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun MegaHandPreview(){
    val scrollState = rememberScrollState()
    Surface {
        MegaHand(scrollState = scrollState)
    }
}



