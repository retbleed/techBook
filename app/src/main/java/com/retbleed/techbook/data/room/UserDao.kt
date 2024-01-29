package com.retbleed.techbook.data.room
import com.retbleed.techbook.data.User
import androidx.room.*
import com.retbleed.techbook.utils.api.image.UserItem

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE userId = :userId")
    suspend fun getUserById(userId: Long): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserItem>)

}
