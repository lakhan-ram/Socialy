package com.example.socialy.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.socialy.R
import com.example.socialy.databinding.FragmentSignUpNameBinding

class SignUpNameFragment : Fragment() {
    private lateinit var binding: FragmentSignUpNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpNameBinding.inflate(inflater, container, false)
        binding.btnBackSignUpName.setOnClickListener {
            findNavController().navigate(R.id.action_signUpNameFragment_to_welcomeFragment)
        }

        binding.btnNextSignUpName.setOnClickListener {
            val name = binding.etTextName.text.toString()
            val bundle = Bundle()
            bundle.putString("name", name)
            if (name.isNotEmpty()) {
                findNavController().navigate(R.id.action_signUpNameFragment_to_signUpEmailFragment, bundle)
            } else {
                binding.textInputLayoutName.error = "Please enter your name"
            }
        }
        return binding.root
    }

}