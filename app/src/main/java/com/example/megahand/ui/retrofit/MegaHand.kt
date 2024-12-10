package com.example.megahandapp.ui.retrofit

import retrofit2.http.GET

interface MegaHand {
    @GET("stories/")
    suspend fun getStories(): Array<StoriesResponse>

    @GET("collections/")
    suspend fun getCollection():Array<CollectionsResponse>

    @GET("news/")
    suspend fun getNews(): Array<NewsResponse>

    @GET("brands/")
    suspend fun getBrands(): Array<BrandsResponse>

    @GET("banners/")
    suspend fun getBanners(): Array<BannersResponse>

    @GET("cities/")
    suspend fun getCities(): Array<CitiesResponse>
}