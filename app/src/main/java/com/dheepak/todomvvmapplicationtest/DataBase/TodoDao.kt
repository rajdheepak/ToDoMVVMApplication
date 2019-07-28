package com.dheepak.todomvvmapplicationtest.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import javax.sql.DataSource

@Dao
interface TodoDao {

    @Query("SELECT * from todo order by Done asc")
    fun getTodos(): LiveData<List<Todo>>

    @Insert
    fun addTodo(todo: Todo)

    @Query("DELETE from Todo where id = :id")
    fun deleteTodo(id: String)

    @Query("UPDATE Todo SET Done = :done where id = :id")
    fun updateStatus(id: String, done: Boolean)

}