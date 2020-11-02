package com.sarkardeveloper.myroomdatabaseapp.RoomDatabase

import androidx.lifecycle.LiveData

class WordRepository(private val wordDao: Dao)
{
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}