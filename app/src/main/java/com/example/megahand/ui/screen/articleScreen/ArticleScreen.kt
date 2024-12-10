package com.example.megahandapp.ui.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.example.megahandapp.R

@Composable
fun ArticleScreen(
    navController: NavHostController,
    scrollState: ScrollState
){
    Scaffold(
        topBar = {
            Header(
                nameCategory = stringResource(R.string.article),
                icon = ImageVector.vectorResource(R.drawable.chevron_left),
                chevronLeftOnClick = {navController.navigate("News")}
            )
        }
    ) {  padding ->
        Box(modifier = Modifier.padding(padding)) {
            CenterArticle(scrollState = scrollState)
        }
    }
}


@Composable
fun CenterArticle(
    scrollState: ScrollState
) {
    Box(contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            MainImage()
            Spacer(modifier = Modifier.height(30.dp))
            MainTitle()
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Деловой стиль одежды для женщин играет важную роль в корпоративной этике и создании первого впечатления. Он формирует нашу профессиональную самопрезентацию, а также влияет на восприятие со стороны коллег, руководства, клиентов и партнеров. В этой статье, мы рассмотрим особенности делового гардероба и поделимся с вами советами, как выглядеть стильно и профессионально в офисе, при этом оставаясь верной себе.",
                fontSize = 14.sp,
                color = Color(0xFF46423E).copy(0.6f),
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
                modifier = Modifier
                    .padding(15.dp, 0.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "Правила классического дресс-кода",
                fontSize = 16.sp,
                color = Color(0xFF46423E),
                fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold))),
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(15.dp, 0.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}


@Composable
fun MainImage(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        AsyncImage(
            model = "https://mhand.ru/media/blog/Деловой_офисный_стиль_одежды_для_женщин.png",
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
}


@Composable
fun MainTitle() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .width(279.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Деловой офисный стиль одежды для женщин",
                    fontSize = 20.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.Bold,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_bold)))
                )
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "5 ч. назад",
                        fontSize = 14.sp,
                        color = Color(0xFF46423E).copy(0.6f),
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.03f)
                            .fillMaxHeight(0.05f)
                            .background(
                                color = Color.White.copy(0.6f),
                                shape = CircleShape
                            )
                    )
                    Text(
                        text = "О поступлениях",
                        fontSize = 14.sp,
                        color = Color(0xFF46423E).copy(0.6f),
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                    )
                }
            }
        }
        Box() {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.share),
                contentDescription = null
            )
        }
    }
}



@Preview
@Composable
fun Preview4(){
    val scrollState = rememberScrollState()
    CenterArticle(scrollState = scrollState)
}