package com.sarkardeveloper.ittest.repository

import androidx.lifecycle.LiveData
import com.sarkardeveloper.ittest.database.ProgressDao
import com.sarkardeveloper.ittest.modul.ProgressDb

class ProgressRepository(private val progressDao: ProgressDao) {

    val readAllData: LiveData<List<ProgressDb>> = progressDao.readAllData()

    suspend fun addTest(test: ProgressDb){
        progressDao.insert(test)
    }
}