package com.example.odontoprev

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odontoprev.databinding.ActivityMainBinding
import com.example.odontoprev.databinding.ActivityPrincipalBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.btnAcessarLogin.setOnClickListener {

            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }

        binding.btnAcessarCadastro.setOnClickListener {

            val intent = Intent(this, cadastroActivity::class.java)
            startActivity(intent)
        }





    }
}