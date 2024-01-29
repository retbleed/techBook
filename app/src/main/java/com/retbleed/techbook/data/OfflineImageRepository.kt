package com.retbleed.techbook.data

import com.retbleed.techbook.data.room.ImageDao
import kotlinx.coroutines.flow.Flow

class OfflineImageRepository(private val imageDao: ImageDao): ImageRepository{
    override fun getAllImageStream(): Flow<List<Image>> = imageDao.getAllImages()
    override fun getImageStream(id: Long): Flow<Image?> = imageDao.getImage(id)
}