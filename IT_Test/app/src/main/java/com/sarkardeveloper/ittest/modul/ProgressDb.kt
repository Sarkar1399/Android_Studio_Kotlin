package com.sarkardeveloper.ittest.modul

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "progress_database")
class ProgressDb(
    @PrimaryKey(autoGenerate = true) var id: Long = 0L,
    @ColumnInfo(name = "name_test") var nameTest: String,
    @ColumnInfo(name = "text_test") var textTest: String,
    @ColumnInfo(name = "test_progress") var testProgress: String
)