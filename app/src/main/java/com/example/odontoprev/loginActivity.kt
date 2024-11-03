package com.example.odontoprev

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odontoprev.databinding.ActivityLoginBinding
import com.example.odontoprev.databinding.ActivityPrincipalBinding
import com.google.firebase.auth.FirebaseAuth

class loginActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    private  val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.btnVoltar.setOnClickListener {
            finish()
        }

    }




}