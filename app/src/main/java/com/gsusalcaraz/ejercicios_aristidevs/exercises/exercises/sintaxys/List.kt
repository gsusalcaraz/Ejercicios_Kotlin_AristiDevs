package com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.sintaxys

fun main() {
    //  inmutableList()
    mutableList()

}

fun mutableList() {
    val weekDays: MutableList<String> =
        mutableListOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

    println(weekDays)
    weekDays.add(0, "NuevoDía")
    println(weekDays)

    if (weekDays.isNotEmpty()) {
        println("La lista no está vacía")
        weekDays.forEach { print("$it; ") }
    }

}

fun inmutableList() {
    val readOnly: List<String> =
        listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")

//    println(readOnly.size)
//    println(readOnly)
//    println(readOnly[1])
//    println(readOnly.last())
//    println(readOnly.first())

    // Filtrar
//    val example = readOnly.filter { it.contains("a") }
//    println(example)

    readOnly.forEach { weekDay -> println(weekDay) }

}
