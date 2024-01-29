package com.retbleed.techbook.utils.api

import com.retbleed.techbook.utils.api.image.ImageApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val imageApiService: ImageApiService = retrofit.create(ImageApiService::class.java)
}