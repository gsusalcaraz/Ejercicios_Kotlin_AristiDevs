package com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.todoapp

// 4 PASO
// CREAR DATA CLASS
data class Task(val name: String, val category: TaskCategory, var isSelected: Boolean = false)