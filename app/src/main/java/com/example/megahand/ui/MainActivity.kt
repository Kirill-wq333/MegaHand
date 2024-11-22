package com.example.megahandapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Surface
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
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
import com.example.megahand.ui.BottomBar
import com.example.megahand.ui.BottomSheet
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



@Composable
fun MegaHand(
    scrollState: ScrollState
) {
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val navController = rememberNavController()


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

            ModalBottomSheetLayout(
                sheetState = sheetState,
                sheetContent = {
                    BottomSheet(
                        sheetState = sheetState,
                        navController = navController
                    )
                },
                sheetGesturesEnabled = false,
            ) {}
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



