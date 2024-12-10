package com.example.megahand.ui.retrofit

data class StoriesItem(
    val image: String,
    val name: String
)

data class CollectionItem(
    val image: List<String>
)

data class BrandItem(
    val image: String
)

data class BannersItem(
    val photo: String
)

data class CitiesItem(
    val citi: String
)