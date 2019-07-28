package com.dheepak.todomvvmapplicationtest.Repository

import androidx.lifecycle.LiveData
import com.dheepak.todomvvmapplicationtest.DataBase.Todo
import com.dheepak.todomvvmapplicationtest.DataBase.TodoDB

class TodoRepositoryImpl(val todoDB: TodoDB): TodoRepository {

    override fun getTodo(): LiveData<List<Todo>> {
        return todoDB.todoDao.getTodos()
    }

    override fun deleteTodo(id: String) {
        todoDB.todoDao.deleteTodo(id)
    }

    override fun updateStatus(id: String, done: Boolean) {
        todoDB.todoDao.updateStatus(id, done)
    }

    override fun addTodo(todo: Todo) {
        todoDB.todoDao.addTodo(todo)
    }

}