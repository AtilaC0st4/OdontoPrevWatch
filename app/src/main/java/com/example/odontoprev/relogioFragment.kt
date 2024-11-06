package com.example.odontoprev

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.odontoprev.databinding.FragmentRelogioBinding
import com.google.firebase.auth.FirebaseAuth

class relogioFragment : Fragment() {

    private var _binding: FragmentRelogioBinding? = null
    private val binding get() = _binding!!

    private val autenticacao by lazy {
        FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRelogioBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnAdicionarHorario.setOnClickListener {
            abrirAdicionarHorarioFragment()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun abrirAdicionarHorarioFragment() {
        val fragment = AdicionarHorarioFragment()
        parentFragmentManager.beginTransaction()
            .replace(R.id.frameAdicionarHorario, fragment)
            .addToBackStack(null)
            .commit()
    }
}
