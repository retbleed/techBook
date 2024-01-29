package com.retbleed.techbook.data
import androidx.room.*

data class UserWithImagesAndComments(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userID",
        entityColumn = "userID"
    )
    val images: List<Image>,
    @Relation(
        parentColumn = "userID",
        entityColumn = "userID"
    )
    val comments: List<Comment>
)
