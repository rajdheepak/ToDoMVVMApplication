package com.dheepak.todomvvmapplicationtest.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Todo::class], version = 1)
abstract class TodoDB: RoomDatabase() {
    abstract val todoDao: TodoDao
}