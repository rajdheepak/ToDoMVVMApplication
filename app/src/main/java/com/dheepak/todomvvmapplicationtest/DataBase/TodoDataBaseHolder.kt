package com.dheepak.todomvvmapplicationtest.DataBase

import android.content.Context
import androidx.room.Room

class TodoDataBaseHolder {
    companion object {
        private var todoDb: TodoDB? = null
        fun getDb(context: Context): TodoDB? {
            if(todoDb == null) {
                synchronized(this) {
                    todoDb = Room.databaseBuilder(context,TodoDB::class.java,"todo").build()
                    return todoDb
                }
            }
            return todoDb
        }
    }
}