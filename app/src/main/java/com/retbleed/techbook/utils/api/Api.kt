package com.retbleed.techbook.utils.api

import com.retbleed.techbook.utils.api.image.CommentApiService
import com.retbleed.techbook.utils.api.image.ImageApiService
import com.retbleed.techbook.utils.api.image.UserApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val imageApiService: ImageApiService = retrofit.create(ImageApiService::class.java)
    val userApiService: UserApiService = retrofit.create(UserApiService::class.java)
    val commentApiService: CommentApiService = retrofit.create(CommentApiService::class.java)
}