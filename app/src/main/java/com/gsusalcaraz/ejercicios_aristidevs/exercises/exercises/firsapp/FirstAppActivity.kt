package com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.firsapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.gsusalcaraz.ejercicios_aristidevs.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnHola = findViewById<AppCompatButton>(R.id.btnHola)
        val etHola = findViewById<AppCompatEditText>(R.id.etNombre)


        btnHola.setOnClickListener {
            val nombre = etHola.text.toString()
            if (nombre.isNotEmpty()) {
                //Log.i("Hola", "Botón pulsado $nombre")
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", nombre)
                startActivity(intent)
            }
        }
    }
}