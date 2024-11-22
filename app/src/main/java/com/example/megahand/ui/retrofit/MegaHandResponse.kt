package com.example.megahandapp.ui.retrofit

import com.google.gson.annotations.SerializedName



data class StoriesResponse(
    @SerializedName("id")val id: Int,
    @SerializedName("photo")val photo: String,
    @SerializedName("title")val title: String,
    @SerializedName("description")val description: String,
    @SerializedName("link")val link: String
)

data class BannersResponse(
    val id: Int,
    val photo: String
)

data class CollectionsResponse(
    val forWho: Int,
    val wear: String,
    val description: String,
    val images: List<String>
)

data class BrandsResponse(
    val id: Int,
    val logo: String,
    val name: String
)

data class CitiesResponse(
     val city: String
)

data class NewsResponse(
    val id: Int,
    val photo: String,
    val url: String,
    val name: String,
    val dateCreate: Number
)
