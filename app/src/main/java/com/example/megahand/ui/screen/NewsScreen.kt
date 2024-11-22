package com.example.megahandapp.ui.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.megahandapp.R





@Composable
fun CenterNew(scrollState: ScrollState) {
    val navController = rememberNavController()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainNew(
                nameNews = "Деловой офисный стиль одежды для женщин",
                dateCreate = "5 ч. назад",
                mainPhoto = "https://mhand.ru/media/blog/Деловой_офисный_стиль_одежды_для_женщин.png",
                copu = listOf("Копировать"),
                applications = listOf("Вконтакте","Телеграмм","Однаклассники","Whatsapp","Viber")
            )
            Spacer(modifier = Modifier.height(15.dp))
            BottomsCenterNew()
            Spacer(modifier = Modifier.height(40.dp))
            SingleBlogNoteContainer(
                navController = navController
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNew(
    modifier: Modifier = Modifier,
    mainPhoto: String,
    dateCreate: String,
    applications: List<String>,
    copu: List<String>,
    nameNews: String
) {
    val isExpanded = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        AsyncImage(
            model = mainPhoto,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .width(250.dp)
                    .clickable { }
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(15.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = nameNews,
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(listOf(Font(R.font.manrope_bold)))
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = dateCreate,
                            fontSize = 14.sp,
                            color = Color.White.copy(0.6f),
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
                            color = Color.White.copy(0.6f),
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                        )
                    }
                }
            }
            ExposedDropdownMenuBox(
                modifier = modifier
                    .fillMaxWidth()
                    .background(
                        color = Color.White.copy(0f),
                        shape = RoundedCornerShape(12.dp)
                    ),
                expanded = isExpanded.value,
                onExpandedChange = { isExpanded.value = it },
                content = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.share),
                            contentDescription = null
                        )
                    }
                    ExposedDropdownMenu(
                        modifier = Modifier
                            .background(color = Color.White),
                        expanded = isExpanded.value,
                        onDismissRequest = { isExpanded.value = false }
                    ) {
                        copu.forEach { item ->
                            DropdownMenuItem(
                                leadingIcon = {
                                    Icon(
                                        imageVector = ImageVector.vectorResource(R.drawable.copy),
                                        contentDescription = null,
                                        tint = Color(0xFF46423E)
                                    )
                                },
                                text = {
                                    Text(
                                        text = item,
                                        color = Color(0xFF46423E),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                                    )
                                },
                                onClick = { isExpanded.value = false }
                            )
                        }
                        applications.forEach { item ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = item,
                                        color = Color(0xFF46423E).copy(0.6f),
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Medium,
                                        fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                                    )
                                },
                                onClick = { isExpanded.value = false }
                            )
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun BottomsCenterNew() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 0.dp,
                end = 0.dp,
                start = 15.dp,
                bottom = 0.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            NewsBottom(text = "Все новости")
            Spacer(modifier = Modifier.width(15.dp))
            NewsBottom(text = "Уход за одеждой")
            Spacer(modifier = Modifier.width(15.dp))
            NewsBottom(text = "Мода и стиль")
        }
    }
}

@Composable
fun NewsBottom(
    text: String
){
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(40.dp)
            .border(
                width = 1.dp,
                color = Color(0xFF46423E).copy(0.05f),
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF46423E),
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
        )
    }
}




@Composable
fun SingleBlogNoteContainer(
    navController: NavHostController
){
    NavHost(
        startDestination = "Все новости",
        navController = navController
    ){
        composable("Все новости") {
            SingleBlog()
        }
    }
}

@Composable
fun SingleBlog() {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        SingleBlogNote(
            dateCreate = "2023-09-14",
            photo = "https://mhand.ru/media/blog/%D0%9E%D0%B4%D0%B5%D0%B6%D0%B4%D0%B0_%D0%BA%D0%B0%D0%BA_%D1%81%D0%B8%D0%BC%D0%B2%D0%BE%D0%BB_%D1%82%D1%80%D0%B0%D0%BD%D1%81%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D0%B8_%D0%B2%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D0%B5_%D0%BD%D0%B0_%D1%8D%D0%BC%D0%BE%D1%86%D0%B8%D0%B8_%D0%B8_%D1%81%D0%BE%D0%B7%D0%BD%D0%B0%D0%BD%D0%B8%D0%B5.jpg",
            nameNews = "Одежда как символ трансформации: влияние на эмоции и сознание",
            typeCategory = "Мода"
        )
        Spacer(modifier = Modifier.height(40.dp))
        SingleBlogNote(
            dateCreate = "2023-09-14",
            photo = "https://mhand.ru/media/blog/%D0%9E%D0%B4%D0%B5%D0%B6%D0%B4%D0%B0_%D0%BA%D0%B0%D0%BA_%D1%81%D0%B8%D0%BC%D0%B2%D0%BE%D0%BB_%D1%82%D1%80%D0%B0%D0%BD%D1%81%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D0%B8_%D0%B2%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D0%B5_%D0%BD%D0%B0_%D1%8D%D0%BC%D0%BE%D1%86%D0%B8%D0%B8_%D0%B8_%D1%81%D0%BE%D0%B7%D0%BD%D0%B0%D0%BD%D0%B8%D0%B5.jpg",
            nameNews = "Одежда как символ трансформации: влияние на эмоции и сознание",
            typeCategory = "Мода"
        )
        Spacer(modifier = Modifier.height(40.dp))
        SingleBlogNote(
            dateCreate = "2023-09-14",
            photo = "https://mhand.ru/media/blog/%D0%9E%D0%B4%D0%B5%D0%B6%D0%B4%D0%B0_%D0%BA%D0%B0%D0%BA_%D1%81%D0%B8%D0%BC%D0%B2%D0%BE%D0%BB_%D1%82%D1%80%D0%B0%D0%BD%D1%81%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D0%B8_%D0%B2%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D0%B5_%D0%BD%D0%B0_%D1%8D%D0%BC%D0%BE%D1%86%D0%B8%D0%B8_%D0%B8_%D1%81%D0%BE%D0%B7%D0%BD%D0%B0%D0%BD%D0%B8%D0%B5.jpg",
            nameNews = "Одежда как символ трансформации: влияние на эмоции и сознание",
            typeCategory = "Мода"
        )
        Spacer(modifier = Modifier.height(40.dp))
        SingleBlogNote(
            dateCreate = "2023-09-14",
            photo = "https://mhand.ru/media/blog/%D0%9E%D0%B4%D0%B5%D0%B6%D0%B4%D0%B0_%D0%BA%D0%B0%D0%BA_%D1%81%D0%B8%D0%BC%D0%B2%D0%BE%D0%BB_%D1%82%D1%80%D0%B0%D0%BD%D1%81%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D0%B8_%D0%B2%D0%BB%D0%B8%D1%8F%D0%BD%D0%B8%D0%B5_%D0%BD%D0%B0_%D1%8D%D0%BC%D0%BE%D1%86%D0%B8%D0%B8_%D0%B8_%D1%81%D0%BE%D0%B7%D0%BD%D0%B0%D0%BD%D0%B8%D0%B5.jpg",
            nameNews = "Одежда как символ трансформации: влияние на эмоции и сознание",
            typeCategory = "Мода"
        )
    }
}


@Composable
fun SingleBlogNote(
    dateCreate: String,
    photo: String,
    nameNews: String,
    typeCategory: String
) {
    Box(
        contentAlignment = Alignment.Center
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(223.dp),
                verticalArrangement = Arrangement.spacedBy(22.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = nameNews,
                    fontSize = 16.sp,
                    lineHeight = 19.2.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold)))
                )
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = dateCreate,
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
                                color = Color(0xFF46423E).copy(0.6f),
                                shape = CircleShape
                            )
                    )
                    Text(
                        text = typeCategory,
                        fontSize = 14.sp,
                        color = Color(0xFF46423E).copy(0.6f),
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(listOf(Font(R.font.manrope_medium)))
                    )
                }
            }
            Box(
                contentAlignment = Alignment.Center
            ){
                Box(
                    modifier = Modifier
                        .width(110.dp)
                        .height(80.dp)
                ) {
                    AsyncImage(
                        model = photo,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

