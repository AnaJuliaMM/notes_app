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

        val btnAddNote = findViewById<FloatingActionButton>(R.id.botao_adicionar_nota)
        btnAddNote.setOnClickListener { view ->
            app(view)
        }

    }

    private fun app(view: View?) {
        val popUpTitle = AlertDialog.Builder(this)
        popUpTitle.setTitle("No que você está pensando?")

        val titleText = EditText(this)
        popUpTitle.setView(titleText)

        popUpTitle.setPositiveButton("Adicionar") { dialog, _ ->

            if (titleText.text.isEmpty()) {
                Toast.makeText(this, "Melhor não adicionar notas vazias", Toast.LENGTH_SHORT).show()
            } else {
                val noteView =  TextView(this)
                noteView.text = titleText.text.toString()
                val params = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(0, 10, 0, 0)
                noteView.layoutParams = params
                noteView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17f)
                noteView.setBackgroundColor(ContextCompat.getColor(this, R.color.note_bg))
                noteView.setTextColor(ContextCompat.getColor(this, R.color.black))
                noteView.setPadding(15, 10, 10, 15 )

                val noteListView = findViewById<LinearLayout>(R.id.lista_notas)
                noteListView.addView(noteView)
            }

        }
        popUpTitle.setNegativeButton("Cancelar") { dialog, _ ->
            dialog.cancel()
        }

        popUpTitle.show()
    }
}

