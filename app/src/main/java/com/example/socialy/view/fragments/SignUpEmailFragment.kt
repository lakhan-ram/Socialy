package com.example.socialy.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.socialy.R
import com.example.socialy.databinding.FragmentSignUpEmailBinding

class SignUpEmailFragment : Fragment() {
    private lateinit var binding: FragmentSignUpEmailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpEmailBinding.inflate(inflater, container, false)
        binding.btnBackSignUpEmail.setOnClickListener {
            findNavController().navigate(R.id.action_signUpEmailFragment_to_signUpNameFragment)
        }

        binding.btnNextSignUpEmail.setOnClickListener {
            findNavController().navigate(R.id.action_signUpEmailFragment_to_signUpPasswordFragment)
        }
        return binding.root
    }
}