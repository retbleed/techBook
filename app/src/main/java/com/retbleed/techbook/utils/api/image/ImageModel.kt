package com.retbleed.techbook.utils.api.image

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retbleed.techbook.data.AppDatabase
import com.retbleed.techbook.utils.api.ApiService
import kotlinx.coroutines.launch
import retrofit2.http.GET

data class UserItem(
    val username: String,
    val email: String
)

data class ImageItem(
    val url: String,
    val title: String
)

data class CommentItem(
    val body: String,
    val email: String,
)

interface UserApiService{
    @GET("users")
    suspend fun getUsers(): List<UserItem>
}

interface ImageApiService {
    @GET("photos")
    suspend fun getImages(): List<ImageItem>
}

interface CommentApiService{
    @GET("comments")
    suspend fun getComments(): List<CommentItem>
}

class ImageViewModel(private val context: Context) : ViewModel() {
    private val userDao = AppDatabase.getInstance(context).userDao()
    private val imageDao = AppDatabase.getInstance(context).imageDao()

    fun loadAndInsertData() {
        viewModelScope.launch {
            try {
                val users = ApiService.userApiService.getUsers()
                val images = ApiService.imageApiService.getImages()

                userDao.insertUsers(users)
                imageDao.insertImages(images)
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}
