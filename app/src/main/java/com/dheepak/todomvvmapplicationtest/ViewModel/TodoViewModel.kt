package com.dheepak.todomvvmapplicationtest.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dheepak.todomvvmapplicationtest.DataBase.Todo
import com.dheepak.todomvvmapplicationtest.Repository.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TodoViewModel(val todoRepository: TodoRepository): ViewModel() {

    val job = Job()
    var todoAppScope = CoroutineScope(Dispatchers.Main + job)

    fun getTodo(): LiveData<List<Todo>> {
        return todoRepository.getTodo()
    }

    fun addTodo(todo: Todo) {
        todoAppScope.launch(Dispatchers.IO) {
            todoRepository.addTodo(todo)
        }
    }

    fun deleteTodo(id: String) {
        todoAppScope.launch(Dispatchers.IO) {
            todoRepository.deleteTodo(id)
        }
    }

    fun updateTodo(id: String, done: Boolean) {
        todoAppScope.launch(Dispatchers.IO) {
            todoRepository.updateStatus(id, done)
        }
    }
}