package com.retbleed.techbook.data

import androidx.room.*

@Entity(tableName = "Images",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userID"],
            childColumns = ["userID"],
            onDelete = ForeignKey.CASCADE

        )
    ])
data class Image(
    @PrimaryKey val id: Long,
    val userID: Long,
    val url: String,
    val description: String,
)
