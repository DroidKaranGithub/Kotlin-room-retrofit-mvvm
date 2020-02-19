package com.example.kotlintesting.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlintesting.mvvm.model.UserResponseModel

@Database(entities = arrayOf(UserResponseModel.User::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): DaoUser



    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

    fun getDatabase(
        context: Context
    ): AppDatabase {
        // if the INSTANCE is not null, then return it,
        // if it is, then create the database
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "database"
            ).allowMainThreadQueries()
                .build()
            INSTANCE = instance
            // return instance
            instance
        }
    }
}

}