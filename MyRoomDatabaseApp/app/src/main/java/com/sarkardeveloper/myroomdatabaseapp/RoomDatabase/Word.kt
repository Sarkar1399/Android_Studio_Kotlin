package com.sarkardeveloper.myroomdatabaseapp.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
class Word(
    @PrimaryKey(autoGenerate = true)
    var id: String,

    @ColumnInfo(name = "word")
    val word: String
)