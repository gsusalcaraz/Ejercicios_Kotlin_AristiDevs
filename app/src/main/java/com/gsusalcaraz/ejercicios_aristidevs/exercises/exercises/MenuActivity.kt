package com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.gsusalcaraz.ejercicios_aristidevs.R
import com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.firsapp.FirstAppActivity
import com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.imccalculator.ImcCalculatorActivity
import com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.superheroapp.SuperHeroListActivity
import com.gsusalcaraz.ejercicios_aristidevs.exercises.exercises.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODOApp = findViewById<Button>(R.id.btnTODO)
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)

        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnIMCApp.setOnClickListener { navigitateToIMCApp() }
        btnTODOApp.setOnClickListener { navigateToTODOAPP() }
        btnSuperHero.setOnClickListener { navigateTobtnSuperHero() }
    }

    private fun navigateTobtnSuperHero() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODOAPP() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigitateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

}

