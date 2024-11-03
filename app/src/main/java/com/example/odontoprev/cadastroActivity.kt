package com.example.odontoprev

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odontoprev.databinding.ActivityCadastroBinding
import com.example.odontoprev.databinding.ActivityPrincipalBinding
import com.google.firebase.auth.FirebaseAuth

class cadastroActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }

    private  val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnEntrar.setOnClickListener{
            cadastroUsuario()
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }


    private fun cadastroUsuario() {
        val email = binding.editTxtLogin.text.toString()
        val senha = binding.editTxtSenha.text.toString()

        autenticacao.createUserWithEmailAndPassword(email, senha)
            .addOnSuccessListener { authResult ->
                AlertDialog.Builder(this)
                    .setTitle("SUCESSO")
                    .setMessage("Sucesso ao criar conta.")
                    .setPositiveButton("OK"){dialog,posicao->
                        startActivity(Intent(this,MainActivity::class.java))
                    }
                    .setCancelable(false).create().show()

            }.addOnFailureListener { exception ->
                val mensagemErro = exception.message
                AlertDialog.Builder(this)
                    .setTitle("ERROR")
                    .setMessage("Error ao criar conta ${mensagemErro}")
                    .setPositiveButton("Fechar"){dialog,posicao->}
                    .create().show()

            }

    }
}