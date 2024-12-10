package com.example.megahand.ui.screen.citiesScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.megahand.ui.Header
import com.example.megahand.ui.screen.citiesScreen.components.BlockItem
import com.example.megahand.ui.screen.citiesScreen.components.Letter
import com.example.megahand.ui.screen.citiesScreen.components.SearchItem
import com.example.megahandapp.R


@Composable
fun CitiesScreen(
    modifier: Modifier = Modifier
) {


    Scaffold(
        topBar = {
            Header(
                chevronLeftOnClick = {},
                nameCategory = stringResource(R.string.citi),
                icon = ImageVector.vectorResource(R.drawable.chevron_left)
            )
        }
    ) {
        Box(modifier = modifier.padding(it)){
            MainCities(placeholder = "Поиск по названию")
        }
    }
}


@Composable
fun MainCities(
    placeholder: String
) {
    val letter = listOf(
        Letter("Все"),
        Letter("А"),
        Letter("Б"),
        Letter("В"),
        Letter("Г"),
        Letter("Д"),
        Letter("Е"),
        Letter("Ж"),
        Letter("З"),
        Letter("Е"),
        Letter("И"),
        Letter("К"),
        Letter("Л"),
        Letter("М"),
        Letter("Н"),
        Letter("О"),
        Letter("П"),
        Letter("Р"),
        Letter("С"),
        Letter("Т"),
        Letter("У"),
        Letter("Ф"),
        Letter("Х"),
        Letter("Ц"),
        Letter("Ч"),
        Letter("Ш"),
        Letter("Щ"),
        Letter("Э"),
        Letter("Ю"),
        Letter("Я"),
    )
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        SearchItem(placeholder = placeholder)
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow {
            item(letter) {
                BlockItem(
                    onSelect = false,
                    letter = ""
                )
            }
        }
    }
}


@Preview
@Composable
private fun PreviewR() {
    CitiesScreen()
}