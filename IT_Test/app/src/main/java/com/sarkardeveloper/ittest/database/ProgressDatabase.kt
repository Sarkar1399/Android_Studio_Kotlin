package com.sarkardeveloper.ittest.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sarkardeveloper.ittest.modul.ProgressDb

@Database(entities = [ProgressDb::class], version = 1)
abstract class ProgressDatabase: RoomDatabase() {

    abstract fun progressDao(): ProgressDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ProgressDatabase? = null

        fun getDatabase(context: Context): ProgressDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProgressDatabase::class.java,
                    "progress"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}