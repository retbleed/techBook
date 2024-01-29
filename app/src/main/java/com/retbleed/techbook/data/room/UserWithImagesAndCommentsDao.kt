package com.retbleed.techbook.data.room
import com.retbleed.techbook.data.UserWithImagesAndComments
import androidx.room.*

@Dao
interface UserWithImagesAndCommentsDao {
    @Transaction
    @Query("SELECT * FROM users")
    suspend fun getUsersWithImagesAndComments(): List<UserWithImagesAndComments>
}
