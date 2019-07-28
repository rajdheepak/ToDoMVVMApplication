@file:Suppress("UNCHECKED_CAST")

package com.dheepak.todomvvmapplicationtest.ViewModel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.dheepak.todomvvmapplicationtest.DataBase.TodoDataBaseHolder
import com.dheepak.todomvvmapplicationtest.Repository.TodoRepositoryImpl

object TodoViewModelProvider {
    fun getTodoViewModel(activity: AppCompatActivity): TodoViewModel {
        return ViewModelProviders.of(activity, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return TodoViewModel(TodoRepositoryImpl(TodoDataBaseHolder.getDb(activity.applicationContext)!!)) as T
            }

        })[TodoViewModel::class.java]
    }
}