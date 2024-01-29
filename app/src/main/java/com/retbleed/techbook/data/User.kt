package com.retbleed.techbook.data
import androidx.room.*
@Entity(tableName = "Users")
data class User(
    @PrimaryKey val userId: Long,
    val username: String,
    val password: String
)
