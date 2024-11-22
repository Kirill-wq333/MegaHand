package com.example.megahandapp.ui.retrofit

import retrofit2.http.GET

interface MegaHand {
    @GET("stories/")
    suspend fun getStories(): Array<StoriesResponse>

    @GET("collections/")
    suspend fun getCollection():CollectionsResponse

    @GET("news/")
    suspend fun getNews():NewsResponse
}