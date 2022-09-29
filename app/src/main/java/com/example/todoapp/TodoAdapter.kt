package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(var dataList: List<TodoModel>, val onClick:(Boolean, Int)->Unit): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textView: TextView
        val checkbox: CheckBox
        init {
            textView = view.findViewById(R.id.tv_task)
            checkbox = view.findViewById(R.id.checkBox)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return  TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val item = dataList[position]
        holder.textView.text = item.taskName
        holder.checkbox.isChecked = item.isDone
        holder.checkbox.setOnCheckedChangeListener { compoundButton, b ->
            onClick(b, position)
        }
    }

    override fun getItemCount(): Int {
        return  dataList.size
    }

    fun updateData(updatedDataList: List<TodoModel>){
        dataList = updatedDataList
        notifyDataSetChanged()
    }
}