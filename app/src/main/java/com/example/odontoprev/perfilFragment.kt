package com.example.odontoprev

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.odontoprev.databinding.FragmentPerfilBinding
import com.google.firebase.auth.FirebaseAuth

class perfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnSair.setOnClickListener {
            autenticacao.signOut()
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(requireContext(), "Desconectado com sucesso", Toast.LENGTH_SHORT).show()
        }


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
