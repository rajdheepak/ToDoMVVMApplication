package com.dheepak.todomvvmapplicationtest.View

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dheepak.todomvvmapplicationtest.Adapter.TodoRecyclerViewAdapter
import com.dheepak.todomvvmapplicationtest.R
import com.dheepak.todomvvmapplicationtest.ViewModel.TodoViewModel
import com.dheepak.todomvvmapplicationtest.ViewModel.TodoViewModelProvider
import kotlinx.android.synthetic.main.fragment_todo_listing.*

class TodoListingFragment : Fragment() {

    lateinit var todoViewModel: TodoViewModel
    lateinit var adapter: TodoRecyclerViewAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        todoViewModel = TodoViewModelProvider.getTodoViewModel(activity as AppCompatActivity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_todo_listing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_todo.setOnClickListener {
            findNavController().navigate(R.id.action_todoListingFragment_to_addTodoFragment)
        }

        adapter = TodoRecyclerViewAdapter(listOf(),object : TodoRecyclerViewAdapter.AdapterListener {
            override fun onDoneToggled(id: String, done: Boolean) {
                todoViewModel.updateTodo(id, done)
            }

            override fun onDelete(id: String) {
                todoViewModel.deleteTodo(id)
            }

        })
        todo_list.adapter = adapter
        todo_list.layoutManager = LinearLayoutManager(context)
    }

    override fun onStart() {
        super.onStart()
        todoViewModel.getTodo().observe(this, Observer {
            adapter.updateData(it!!)
        })
    }

}
