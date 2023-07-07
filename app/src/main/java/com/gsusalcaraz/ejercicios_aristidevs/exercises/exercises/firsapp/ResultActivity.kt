package com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.firsapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gsusalcaraz.ejercicios_aristidevs.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val etResultado = findViewById<TextView>(R.id.tvResultado)

        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()

        etResultado.text = "Hola $name"

    }
}