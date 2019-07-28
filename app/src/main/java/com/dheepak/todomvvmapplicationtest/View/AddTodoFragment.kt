package com.dheepak.todomvvmapplicationtest.View


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dheepak.todomvvmapplicationtest.DataBase.Todo
import com.dheepak.todomvvmapplicationtest.R
import com.dheepak.todomvvmapplicationtest.ViewModel.TodoViewModel
import com.dheepak.todomvvmapplicationtest.ViewModel.TodoViewModelProvider
import kotlinx.android.synthetic.main.fragment_add_todo.*
import java.util.*

class AddTodoFragment : Fragment() {

    lateinit var todoViewModwl: TodoViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        todoViewModwl = TodoViewModelProvider.getTodoViewModel(activity as AppCompatActivity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add_notes.setOnClickListener {
            if(!(todo_text.text.isNullOrEmpty() || todo_text.text.isNullOrBlank())) {
                //add a note
                val todo: Todo = Todo(UUID.randomUUID().toString(),todo_text.text.toString(),false)
                todoViewModwl.addTodo(todo)
                findNavController().navigateUp()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }


}
