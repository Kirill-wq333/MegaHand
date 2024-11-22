package com.example.megahandapp.ui.checking

import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.megahandapp.R
import com.example.megahandapp.ui.retrofit.RetrofitClient
import com.example.megahandapp.ui.retrofit.StoriesResponse

@Composable
fun MhandScreen() {
    var stories by remember { mutableStateOf<List<StoriesResponse>?>(null) }
    var photo by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
       try {
             val stories = RetrofitClient.apiService.getStories()
//           photo = stories.photo

        }

        catch (e: Exception) {
            Log.e("MegaHand", "Error fetching stories: ${e.message}")
            null
        }

    }

    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = photo,
            contentDescription = "Mhand Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "интернет-магазин",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "MHAND",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "ДРОП теперь каждый день",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Откройте мир моды с эксклюзивными новинками! Каждый день — новые тренды и стильные образы.",
                    fontSize = 14.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { /* действие при нажатии */ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF007bff)), //Синий цвет кнопки
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Подробнее", color = Color.White)
                }
            }
        }

        IconButton(onClick = { }, modifier = Modifier.align(Alignment.TopEnd).padding(16.dp)) {
            Icon(painter = painterResource(id = R.drawable.close), contentDescription = "Close")
        }
    }
}



@Composable
fun Stories(
    navController: NavHostController
){
    Scaffold(
        topBar = {
//            StoriesTopBar()
            Sequential()
        }
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
//        NavHost(
//            startDestination = "Stories1",
//            navController = navController
//        ) {}
           MhandScreen()
        }
    }
}



@Composable
fun Sequential(durationMillis: Long = 3000) {
    val coroutineScope = rememberCoroutineScope()
    val progress1 = remember { Animatable(0f) }
    val progress2 = remember { Animatable(0f) }
    val progress3 = remember { Animatable(0f) }
    var stage by remember { mutableStateOf(0) }

    LaunchedEffect(stage) {
        when (stage) {
            0 -> {
                progress1.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = durationMillis.toInt())
                )
                stage++
            }

            1 -> {
                progress2.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = durationMillis.toInt())
                )
                stage++
            }

            2 -> {
                progress3.animateTo(
                    targetValue = 1f,
                    animationSpec = tween(durationMillis = durationMillis.toInt())
                )

            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            LinearProgressIndicator(
                progress = progress1.value,
                modifier = Modifier
                    .width(112.dp)
                    .background(color = Color(0xFF46423E))
            )
            LinearProgressIndicator(
                progress = progress2.value,
                modifier = Modifier
                    .width(112.dp)
                    .background(color = Color(0xFF46423E))
            )
            LinearProgressIndicator(
                progress = progress3.value,
                modifier = Modifier
                    .width(112.dp)
                    .background(color = Color(0xFF46423E))
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Stories1Prev(){
    val navController = rememberNavController()
    Stories(
        navController = navController
    )
}




