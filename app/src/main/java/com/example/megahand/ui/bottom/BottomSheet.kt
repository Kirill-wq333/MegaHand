package com.example.megahand.ui.bottom


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.megahandapp.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    sheetState: SheetState,
    navController: NavHostController
) {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Box(
        Modifier.fillMaxWidth()
            .height(181.dp)
            .background(
                color =  Color.White
            )
    ) {
        Column(
            Modifier.fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.other),
                    fontSize = 20.sp,
                    color = Color(0xFF46423E),
                    fontFamily = FontFamily(listOf(Font(R.font.manrope_bold))),
                    fontWeight = FontWeight.Bold
                )
                Icon(
                    modifier = Modifier
                        .clickable {
                            scope.launch { sheetState.hide() }
                        },
                    painter = painterResource(R.drawable.close),
                    contentDescription = null,
                    tint = Color(0xFF46423E)
                )
            }
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        ButtonItem(
                            nameCategory = stringResource(R.string.help),
                            wight = 61.dp,
                            onClick = {}
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        ButtonItem(
                            nameCategory = stringResource(R.string.news),
                            wight = 59.dp,
                            onClick = {navController.navigate("News")}
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        ButtonItem(
                            nameCategory = stringResource(R.string.job),
                            wight = 51.dp,
                            onClick = {}
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        ButtonItem(
                            nameCategory = stringResource(R.string.service),
                            wight = 45.dp,
                            onClick = {navController.navigate("Service")}
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SheetPreview() {
    val navController = rememberNavController()
    val sheetState = rememberModalBottomSheetState()

    BottomSheet(
        sheetState = sheetState,
        navController = navController
    )
}

@Composable
fun ButtonItem(
    nameCategory: String,
    wight: Dp,
    onClick: () -> Unit
){

    Box(
        modifier = Modifier
            .width(174.dp)
            .height(46.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF46423E).copy(0.05f)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Row {
            Text(
                text = nameCategory,
                fontSize = 16.sp,
                color = Color(0xFF46423E),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(listOf(Font(R.font.manrope_bold)))
            )
            Spacer(modifier = Modifier.width(wight))
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.chevron_right),
                contentDescription = null,
                tint = Color(0xFF46423E)
            )
        }
    }
}
