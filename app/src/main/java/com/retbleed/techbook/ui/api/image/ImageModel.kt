package com.retbleed.techbook.ui.api.image

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.retbleed.techbook.ui.api.ApiService
import kotlinx.coroutines.launch
import retrofit2.http.GET

data class ImageItem(
    val id: String,
    val url: String,
    val title: String
)

interface ImageApiService {
    @GET("photos")
    suspend fun getImages(): List<ImageItem>
}

class ImageViewModel : ViewModel() {
    private val _imageList = MutableLiveData<List<ImageItem>>()
    val imageList: LiveData<List<ImageItem>> get() = _imageList

    fun loadImages() {
        viewModelScope.launch {
            try {
                val result = ApiService.imageApiService.getImages()
                _imageList.value = result
            } catch (e: Exception) {
                println(e)
            }
        }
    }
}
