package com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.todoapp

sealed class TaskCategory (var isSelected:Boolean = true){
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other : TaskCategory()
}