package com.retbleed.techbook.utils.api.image

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retbleed.techbook.data.AppDatabase
import com.retbleed.techbook.utils.api.ApiService
import com.retbleed.techbook.data.room.ImageDao
import kotlinx.coroutines.launch
import retrofit2.http.GET
import retrofit2.http.Query

data class ImageItem(
    val url: String,
    val title: String
)

interface ImageApiService {
    @GET("photos")
    suspend fun getImages(@Query("limit") limit: Int = 50): List<ImageItem>
}

class ImageViewModel:ViewModel() {
    private val imageDao = AppDatabase.getInstance(context = this).imageDao()

    fun loadAndInsertData() {
        viewModelScope.launch {
            try {
                val images = ApiService.imageApiService.getImages()
                imageDao.insertImages(images)
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}
