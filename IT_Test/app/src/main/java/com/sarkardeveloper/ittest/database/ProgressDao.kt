package com.sarkardeveloper.ittest.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sarkardeveloper.ittest.modul.ProgressDb

@Dao
interface ProgressDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(test: ProgressDb)

    @Query("SELECT * from progress_database WHERE id = :key")
    fun get(key: Long): ProgressDb?

    @Query("DELETE FROM progress_database")
    fun clear()

    @Query("SELECT * FROM progress_database ORDER BY id ASC")
    fun readAllData(): LiveData<List<ProgressDb>>

}