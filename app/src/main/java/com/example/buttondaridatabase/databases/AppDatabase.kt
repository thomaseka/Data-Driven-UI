package com.example.buttondaridatabase.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.buttondaridatabase.dao.MsButton
import com.example.buttondaridatabase.dao.ProductDao
import com.example.buttondaridatabase.data.Product
import com.example.buttondaridatabase.data.RectParams

@Database(
    entities = [RectParams::class, Product::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun msButton() : MsButton
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        //clear the log when changing to production environtment
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                try {
                    val instance = INSTANCE ?: Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "ms_button_android"
                    )
                        .createFromAsset("databases/buttonTacpos.db")
                        .build()
                    INSTANCE = instance
                    // Add successful log
                    Log.d("AppDatabase", "Database instance created successfully")
                    instance
                } catch (e: Exception) {
                    Log.d("AppDatabase", "Error creating database: ${e.message}")
                    throw e
                }
            }
        }
    }
}

//        fun getDatabase(context: Context): AppDatabase {
//            return INSTANCE ?: synchronized(this) {
//                return INSTANCE ?: synchronized(this) {
//                    try {
//                        val database = Room.databaseBuilder(context, AppDatabase::class.java, "ms_button")
//                            .createFromAsset("databases/tacpos20.db")
//                            .build()
//                        INSTANCE = database
//                        database
//                    } catch (e: Exception) {
//                        Log.d("AppDatabase", "Error creating database: ${e.message}")
//                        throw e
//                    }
//                }
//            }
//        }