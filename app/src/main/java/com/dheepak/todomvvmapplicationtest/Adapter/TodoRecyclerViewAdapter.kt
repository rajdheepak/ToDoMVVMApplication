package com.dheepak.todomvvmapplicationtest.Adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.dheepak.todomvvmapplicationtest.DataBase.Todo
import com.dheepak.todomvvmapplicationtest.R

class TodoRecyclerViewAdapter(var todo: List<Todo>, val adapterListener: AdapterListener): RecyclerView.Adapter<TodoRecyclerViewAdapter.TodoViewHolder>() {

    override fun getItemCount(): Int {
        return todo.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.todo = todo[position]
        holder.todoText.text = todo[position].todo
        holder.todoCheckBox.isChecked = todo[position].done
        if(todo[position].done) {
            holder.todoText.paintFlags = holder.todoText.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.todoText.paintFlags = Paint.ANTI_ALIAS_FLAG
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_holder, parent, false))
    }

    fun updateData(todo: List<Todo>) {
        this.todo = todo
        notifyDataSetChanged()
    }

    inner class TodoViewHolder(view: View): RecyclerView.ViewHolder(view) {

        lateinit var todo: Todo
        var todoDelete: ImageButton = view.findViewById(R.id.delete_todo)
        var todoText: TextView = view.findViewById(R.id.todo_text)
        var todoCheckBox: CheckBox = view.findViewById(R.id.todo_checkbox)

        init {
            todoDelete.setOnClickListener {
                adapterListener.onDelete(todo.id)
            }
            todoCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
                adapterListener.onDoneToggled(todo.id, isChecked)
            }
        }
    }

    interface AdapterListener {
        fun onDelete(id: String)
        fun onDoneToggled(id: String, done: Boolean)
    }
}