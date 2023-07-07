package com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.sintaxys

fun main() {
    var weekDays = arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo")

//    println(weekDays[2])
//    println(weekDays.size)

//    if (weekDays.size >= 8) {
//        println(weekDays[0])
//    } else
//        println("Fuera de rango")

    weekDays[2] = "Miércoles"

    for (weekDays in weekDays) {
        println("Hoy es: $weekDays")
    }

    for ((position, value) in weekDays.withIndex()) {
        println("La posicion $position, contiene $value")
    }
}