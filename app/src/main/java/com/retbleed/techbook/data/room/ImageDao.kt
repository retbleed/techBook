package com.retbleed.techbook.data.room
import com.retbleed.techbook.data.Image
import androidx.room.*
import com.retbleed.techbook.utils.api.image.ImageItem
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageDao {
    @Insert
    suspend fun insertImage(image: Image)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImages(images: List<Image>)

    @Delete
    suspend fun deleteImage(image: Image)

    @Query("SELECT * FROM Images")
    fun getAllImages(): Flow<List<Image>>

    @Query("SELECT * FROM Images WHERE id = :id")
    fun getImage(id: Long): Flow<Image>

    @Query("DELETE FROM Images")
    suspend fun deleteAllImages()
}
