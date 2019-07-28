package com.dheepak.todomvvmapplicationtest.Repository

import androidx.lifecycle.LiveData
import com.dheepak.todomvvmapplicationtest.DataBase.Todo

interface TodoRepository {
    fun addTodo(todo: Todo)
    fun deleteTodo(id: String)
    fun updateStatus(id: String, done: Boolean)
    fun getTodo(): LiveData<List<Todo>>
}