package com.example.megahandapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.megahand.ui.Collection
import com.example.megahandapp.R
import com.example.megahandapp.ui.retrofit.MainViewModel
import com.example.megahand.ui.BottomCollection
import com.example.megahand.ui.BrandItem
import com.example.megahand.ui.CollectionItem
import com.example.megahand.ui.Stories
import com.example.megahand.ui.StoriesItem

@Composable
fun MainScreen(
    navController: NavHostController
){
    Scaffold(
        topBar = {
            Header(
                nameCategory = "",
                icon = ImageVector.vectorResource(R.drawable.logo_minimized),
                chevronLeftOnClick = {}
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding),
        ) {
            MainContent(
                navController = navController
            )
        }
    }
}


@Composable
fun MainContent(
    navController: NavHostController,
){

    val scrollState = rememberScrollState()

    val vm = viewModel<MainViewModel>()
    val stories by vm.stories.collectAsState()
    val collection by vm.collection.collectAsState()
    val brand by vm.brands.collectAsState()

    LaunchedEffect(Unit) {
        vm.getStories()
    }

    LaunchedEffect(Unit) {
        vm.getCollection()
    }

    LaunchedEffect(Unit) {
        vm.getBrands()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ListStories(stories)
            Spacer(modifier = Modifier.height(30.dp))
            LoyaltyCard()
            Spacer(modifier = Modifier.height(15.dp))
            ServiceAndHelpBottoms(serviceOnClick = { navController.navigate("Service") })
            Spacer(modifier = Modifier.height(30.dp))
            FreeCouponBanner(banner = "https://mhand.ru/media/banner_app/Group_775_2.png")
            Spacer(modifier = Modifier.height(30.dp))
            Collections(navController = rememberNavController(), collection)
            Spacer(modifier = Modifier.height(30.dp))
            Banner()
            Spacer(modifier = Modifier.height(30.dp))
            BrandsList(brand)
        }
    }
}


@Composable
fun ListStories(stories: List<StoriesItem>) {
    LazyRow(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(stories){ item ->
            Stories(
                storiesImage = item.image,
                storiesText = item.name
            )
        }
    }
}


@Composable
fun LoyaltyCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                color = Color(0xFF46423E).copy(0.1f),
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .width(210.dp)
            ) {
                Row(
                    modifier = Modifier.padding(
                        top = 15.dp,
                        end = 0.dp,
                        bottom = 0.dp,
                        start = 15.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.surprisebox),
                        contentDescription = null,
                        tint = Color(0xFFE7D52F)
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Text(
                        text = "7,180 ₽",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(listOf(Font(R.font.manrope_bold))),
                        color = Color(0xFF46423E),
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = "Накоплено баллов",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF46423E),
                    modifier = Modifier
                        .padding(
                            top = 0.dp,
                            end = 0.dp,
                            bottom = 0.dp,
                            start = 15.dp
                        )
                )
                Spacer(modifier = Modifier.height(15.dp))
                Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(color = Color(0xFF46423E).copy(0.1f)))
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 0.dp,
                            end = 0.dp,
                            bottom = 0.dp,
                            start = 15.dp
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "4% кэшбэка",
                        fontSize = 16.sp,
                        color = Color(0xFF46423E),
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold)))
                    )
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.chevron_right),
                        contentDescription = null
                    )
                }
                Text(
                    text = "Заполните профиль чтобы получить больше",
                    fontSize = 14.sp,
                    lineHeight = 18.2.sp,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF46423E),
                    modifier = Modifier
                        .padding(
                            top = 0.dp,
                            end = 0.dp,
                            bottom = 15.dp,
                            start = 15.dp
                        )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(185.dp)
                    .background(
                        color = Color(0xFFE7D52F).copy(0.4f),
                        shape = RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 8.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 8.dp
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = "https://s3-alpha-sig.figma.com/img/2719/c139/e208c90fb342991b1adb967066c3c2bb?Expires=1732492800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=dCYtZrh95-053e5JRCDAiPnlXdUL559CFCDI8mJ6bNUSsTZO-RkS2VLkPkvf1FNq7hYDKG4M2KWPS9OYW4t-mLSWKiLllDj6pFZzh3Hhvn~yZyGx-~YFMU~8VUxBrGy5RTlgv-JtTUKFxgsIHDYfyV6GI5YoLQ3lZuZTS0WqQSXB8ehbEOplpkBxxdi0zW2Gb08Wl3hKK9dLfqx1sm-uQR6qPlbz0V7oHicDh7AXXTb7a~TC6t2ytffoS021mC-CRv289XHholRzrcL7FVS3ZhHV-FghXTcG73VgfBLe4F7cIc6OnKCTPIyl3fCIQHJQtRN6MESdXuLIOg4lqVf25g__",
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .border(
                            width = 1.dp,
                            color = Color(0xFFE7D52F),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clip(shape = RoundedCornerShape(8.dp))
                )
                Image(
                    modifier = Modifier
                        .clickable { },
                    imageVector = ImageVector.vectorResource(R.drawable.magnifier),
                    contentDescription = null
                )

            }
        }
    }
}


@Composable
fun ServiceAndHelpBottoms(
    serviceOnClick: () -> Unit,
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Box(
            modifier = Modifier
                .width(174.dp)
                .height(46.dp)
                .clickable { }
                .background(
                    color = Color(0xFF46423E).copy(0.05f),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(61.dp)
            ) {
                Text(
                    text = stringResource(R.string.help),
                    fontSize = 16.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold))),

                    )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.chevron_right),
                    contentDescription = null
                )
            }
        }
        Box(
            modifier = Modifier
                .width(174.dp)
                .height(46.dp)
                .clickable { serviceOnClick() }
                .background(
                    color = Color(0xFF46423E).copy(0.05f),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(45.dp)
            ) {
                Text(
                    text = stringResource(R.string.service),
                    fontSize = 16.sp,
                    color = Color(0xFF46423E),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_semibold))),

                    )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.chevron_right),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun Collections(
    navController: NavHostController,
    collection: List<CollectionItem>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(R.string.collection),
                fontSize = 20.sp,
                color = Color(0xFF46423E),
                fontFamily = FontFamily(listOf(Font(R.font.manrope_bold))),
                fontWeight = FontWeight.Bold
            )
            BottomCollection(
                navController = navController
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
    NavHost(
        navController = navController,
        startDestination = "Girl"
    ) {
        composable("Girl") {
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(collection) { item ->
                    Collection(collectionImage = item.image)
                }
            }
        }
        composable("Man") {

        }
        composable("Children") {

        }
    }
}


@Composable
fun FreeCouponBanner(
    banner: String
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp),
        contentAlignment = Alignment.TopEnd
    ){
        AsyncImage(
            model = banner,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Icon(
            modifier = Modifier
                .padding(10.dp)
                .clickable { },
            imageVector = ImageVector.vectorResource(R.drawable.cross),
            contentDescription = null,
            tint = Color.Black
        )
    }
}

@Composable
fun Banner(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp, 0.dp),
        contentAlignment = Alignment.TopEnd
    ){
        AsyncImage(
            model = "https://mhand.ru/media/banner_app/1_1089х324.png",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape =  RoundedCornerShape(8.dp))
        )
        Icon(
            modifier = Modifier
                .padding(10.dp)
                .clickable { },
            imageVector = ImageVector.vectorResource(R.drawable.cross),
            contentDescription = null,
            tint = Color.Black
        )
    }
}

@Composable
fun BrandsList(
    brand: List<BrandItem>
) {

    LazyRow(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        items(brand){ item  ->
            BrandBox(
                brandImage = item.image
            )
        }
    }
}


@Composable
fun BrandBox(
    brandImage: String
){
    Box(
        modifier = Modifier
            .width(120.dp)
            .height(35.dp)
    ) {
        AsyncImage(
            model = brandImage,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}


//@Preview
//@Composable
//fun CenterMainPreview(){
//    CenterMain(
//
//    )
//}