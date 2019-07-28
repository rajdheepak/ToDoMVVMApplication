package com.dheepak.todomvvmapplicationtest.DataBase

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "todo", primaryKeys = ["id"])
data class Todo (
    var id: String,
    val todo: String,
    val done: Boolean
)