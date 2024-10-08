package com.example.odontoprev

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
private lateinit var btnEntre:Button
private lateinit var txtBemvindo:TextView
private lateinit var inputNome:EditText



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()


        btnEntre = findViewById(R.id.btnEntre)
        txtBemvindo = findViewById(R.id.txtViewBemVindo)
        inputNome = findViewById(R.id.editTextNome)


        btnEntre.setOnClickListener{

          val nome = inputNome.text.toString()

            txtBemvindo.text = "Seja bem vindo ${nome}"


        }


    }
}