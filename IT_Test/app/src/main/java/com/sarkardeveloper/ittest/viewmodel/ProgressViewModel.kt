package com.sarkardeveloper.ittest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.sarkardeveloper.ittest.database.ProgressDatabase
import com.sarkardeveloper.ittest.repository.ProgressRepository
import com.sarkardeveloper.ittest.modul.ProgressDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProgressViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<ProgressDb>>
    private val repository: ProgressRepository

    init {
        val progressDao = ProgressDatabase.getDatabase(application).progressDao()
        repository = ProgressRepository(progressDao)
        readAllData = repository.readAllData
    }

    fun addTest(test: ProgressDb){
        viewModelScope.launch(Dispatchers.IO) { repository.addTest(test) }
    }
}