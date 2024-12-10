package com.example.megahand.ui.screen.citiesScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.megahandapp.R

@Composable
fun SearchItem(
    modifier: Modifier = Modifier,
    placeholder: String = ""
) {
    val state = remember { mutableStateOf(TextFieldValue("")) }


    OutlinedTextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value },
        trailingIcon = {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.search),
                contentDescription = null,
                tint = Color(0xFF46423E).copy(0.4f)
            )
        },
        textStyle = TextStyle(
            color = Color(0xFF46423E),
            fontSize = 14.sp,
            fontFamily = FontFamily(listOf(Font(R.font.manrope_medium))),
            fontWeight = FontWeight.Medium,
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            focusedBorderColor = Color(0xFFFFE600)
        ),
        modifier = modifier
            .padding(15.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        placeholder = {
            Text(
                text = placeholder,

            )
        },
        singleLine = true
    )

}