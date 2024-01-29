package com.retbleed.techbook.data

import kotlinx.coroutines.flow.Flow


interface ImageRepository {
    fun getAllImageStream(): Flow<List<Image>>
    fun getImageStream(id: Long): Flow<Image?>
}