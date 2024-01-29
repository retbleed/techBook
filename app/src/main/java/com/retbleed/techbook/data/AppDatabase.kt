    package com.retbleed.techbook.data

    import android.content.Context
    import androidx.room.Database
    import androidx.room.Room
    import androidx.room.RoomDatabase
    import com.retbleed.techbook.data.room.CommentDao
    import com.retbleed.techbook.data.room.ImageDao
    import com.retbleed.techbook.data.room.UserDao

    @Database(entities = [User::class, Image::class], version = 1, exportSchema = false)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun userDao(): UserDao
        abstract fun imageDao(): ImageDao
        abstract fun commentDao(): CommentDao

        companion object {
            @Volatile
            private var Instance: AppDatabase? = null

            fun getDatabase(context: Context): AppDatabase {
                return Instance ?: synchronized(this){
                    Room.databaseBuilder(context, AppDatabase::class.java, "tech_database")
                        .build()
                        .also { Instance = it }
                }
            }
        }
    }
