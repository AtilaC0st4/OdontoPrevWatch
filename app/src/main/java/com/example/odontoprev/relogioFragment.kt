package com.example.odontoprev

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.odontoprev.databinding.FragmentRelogioBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class relogioFragment : Fragment() {

    private var _binding: FragmentRelogioBinding? = null
    private val binding get() = _binding!!

    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    private val bancoDeDados by lazy {
        FirebaseFirestore.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRelogioBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnCadastarEscovacao.setOnClickListener{
            cadastrarHorario();
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun cadastrarHorario() {
        val dados = mapOf(
            "nomeDoHorario" to binding.editTextNomeHorario.text.toString(),
            "horario" to binding.editTextHorario.text.toString()
        )

        val idUsuario = autenticacao.currentUser?.uid

        if (idUsuario != null) {
            val referenciaUsuario = bancoDeDados.collection("horarios")
                .document(idUsuario)
                .collection("meusHorarios") // Subcoleção para horários individuais

            referenciaUsuario.add(dados) // `add` gera um ID automaticamente para cada novo horário
                .addOnSuccessListener {
                    Log.i("db_info", "Horário salvo com sucesso")
                    Toast.makeText(requireContext(), "Horário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Log.i("db_info", "Erro ao salvar horário", e)
                    Toast.makeText(requireContext(), "Erro ao salvar horário!", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(requireContext(), "Usuário não autenticado!", Toast.LENGTH_SHORT).show()
        }
    }





}



