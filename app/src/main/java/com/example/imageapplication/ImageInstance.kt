package com.example.imageapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ImageInstance {
    object ImageInstance {
        private var clientObject: ImageInstance? = null
        private var retrofit: Retrofit? = null
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"

        init {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }

        @Synchronized
        fun getInstance(): ImageInstance {
            if (clientObject == null) {
                clientObject = ImageInstance
            }
            return clientObject!!
        }

        fun getApi(): JsonPlaceholderService {
            return retrofit!!.create(JsonPlaceholderService::class.java)
        }
    }
}