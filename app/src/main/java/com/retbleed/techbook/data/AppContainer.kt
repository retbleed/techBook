package com.retbleed.techbook.data

import android.content.Context

interface AppContainer {
    val imageRepository: ImageRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    private val appDatabase: AppDatabase by lazy {
        AppDatabase.getDatabase(context)
    }

    override val imageRepository: ImageRepository by lazy {
        OfflineImageRepository(appDatabase.imageDao())
    }
}