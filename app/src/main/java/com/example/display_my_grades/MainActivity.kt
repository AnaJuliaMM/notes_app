package com.example.display_my_grades

import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)



        // Configure o botão flutuante para abrir o popup
        val btnAddGrade = findViewById<FloatingActionButton>(R.id.botao_adicionar_nota)
        btnAddGrade.setOnClickListener { view ->
            app(view)
        }


    }

    private fun app(view: View?) {
        val popUpTitle = AlertDialog.Builder(this)
        popUpTitle.setTitle("No que você está pensando?")

        val titleText = EditText(this)
        popUpTitle.setView(titleText)

        popUpTitle.setPositiveButton("Ok") { dialog, _ ->

            if (titleText.text.isEmpty()) {
                Toast.makeText(this, "Melhor não adicionar notas vazias", Toast.LENGTH_SHORT).show()
            } else {
                val gradeView =  TextView(this)
                gradeView.text = titleText.text.toString()

                // Configuração de layout para o novo TextView
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 10, 0, 0) // Define margens para o TextView
                gradeView.layoutParams = params
                gradeView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17f)
                gradeView.setBackgroundColor(ContextCompat.getColor(this, R.color.note_bg))
                gradeView.setTextColor(ContextCompat.getColor(this, R.color.black))
                gradeView.setPadding(15, 10, 10, 15 )

                val gradeListView = findViewById<LinearLayout>(R.id.lista_notas)
                gradeListView.addView(gradeView)
            }



        }
        popUpTitle.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        popUpTitle.show()
    }
}

