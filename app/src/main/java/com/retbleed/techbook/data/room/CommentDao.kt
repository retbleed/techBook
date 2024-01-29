package com.retbleed.techbook.data.room
import com.retbleed.techbook.data.Comment
import androidx.room.*

@Dao
interface CommentDao {
    @Insert
    suspend fun insertComment(comment: Comment)

    @Query("SELECT * FROM comments WHERE userId = :userId AND imageId = :imageId")
    suspend fun getCommentsByUserIdAndImageId(userId: Long, imageId: Long): List<Comment>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComments(comments: List<Comment>)
}
