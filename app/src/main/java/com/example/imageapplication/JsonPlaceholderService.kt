package com.example.imageapplication

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceholderService {
    @GET("photos")
    fun getPhotos(): Call<List<ApiModel>>
}