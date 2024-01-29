package com.retbleed.techbook.data

import androidx.room.*

@Entity(tableName = "Images")
data class Image(
    @PrimaryKey val id: Long,
    val url: String,
    val title: String,
)
