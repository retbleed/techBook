package com.retbleed.techbook.data
import androidx.room.*

@Entity(tableName = "comments",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userID"],
            childColumns = ["userID"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Image::class,
            parentColumns = ["imageID"],
            childColumns = ["imageID"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class Comment(
    @PrimaryKey val commentId: Long,
    val userID: Long,
    val imageID: String,
    val body: String,
    val email: String?
)
