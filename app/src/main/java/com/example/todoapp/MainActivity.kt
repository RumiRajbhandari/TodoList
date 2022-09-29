package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var recyclerView: RecyclerView

    val todoList = mutableListOf<TodoModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn_add)
        editText = findViewById(R.id.et_task)
        recyclerView = findViewById(R.id.rv_todo)

        val adapter = TodoAdapter(todoList){isChecked, position ->
            todoList[position].isDone = isChecked
        }
        recyclerView.adapter = adapter

        button.setOnClickListener {
            val todoModel = TodoModel(editText.text.toString(), false)
            todoList.add(todoModel)
            adapter.updateData(todoList)
        }



    }
}