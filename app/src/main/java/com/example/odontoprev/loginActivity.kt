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

        binding.btnEntrar.setOnClickListener {
            logarUsuario()
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }

    }

    private fun logarUsuario() {
        val email = binding.editTxtLogin.text.toString()
        val senha = binding.editTxtSenha.text.toString()

        autenticacao.signInWithEmailAndPassword(email, senha)
            .addOnSuccessListener { authResult ->
                startActivity(Intent(this,PrincipalActivity::class.java))
            }.addOnFailureListener { exception ->
                val mensagemErro = exception.message
                AlertDialog.Builder(this)
                    .setTitle("ERRO")
                    .setMessage("Error ao Logar ${mensagemErro}")
                    .setPositiveButton("Fechar"){dialog,posicao->}
                    .create().show()

            }

    }




}