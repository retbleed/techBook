package com.retbleed.techbook.data.room
import com.retbleed.techbook.data.Image
import androidx.room.*
import com.retbleed.techbook.utils.api.image.ImageItem

@Dao
interface ImageDao {
    @Insert
    suspend fun insertImage(image: Image)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<ImageItem>)
}
