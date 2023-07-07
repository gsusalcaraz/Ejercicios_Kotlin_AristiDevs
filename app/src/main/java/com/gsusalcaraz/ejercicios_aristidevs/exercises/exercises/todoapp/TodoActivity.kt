package com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.gsusalcaraz.ejercicios_aristidevs.R
import com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.todoapp.TaskCategory.Business
import com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.todoapp.TaskCategory.Other
import com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.todoapp.TaskCategory.Personal

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        Personal,
        Business,
        Other
    )

    private val tasks = mutableListOf(
        Task("Prueba business", Business),
        Task("Prueba personal", Personal),
        Task("Prueba other", Other)

    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesApdater: CategoriesAdapter

    private lateinit var favAddTAsk: FloatingActionButton

    // PARA IMPLEMENTAR RECYCLERVIEW
    // 1º PASO
    private lateinit var rvTask: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        favAddTAsk.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }
                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }
        dialog.show()
    }


    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        // 2º PASO
        rvTask = findViewById(R.id.rvTasks)
        favAddTAsk = findViewById(R.id.favAddTAsk)
    }

    private fun initUI() {
        categoriesApdater = CategoriesAdapter(categories) { position -> updateCategories(position) }
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesApdater

        taskAdapter = TaskAdapter(tasks) { position -> onItemSelected(position) }
        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = taskAdapter
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesApdater.notifyItemChanged(position)
        updateTasks()
    }

    private fun updateTasks() {
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { (selectedCategories.contains(it.category)) }
        taskAdapter.tasks = newTasks
        taskAdapter.notifyDataSetChanged()
    }
}