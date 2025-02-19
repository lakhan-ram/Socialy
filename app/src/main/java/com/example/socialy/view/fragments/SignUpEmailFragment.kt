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

        val name = arguments?.getString("name")
        binding.btnNextSignUpEmail.setOnClickListener {
            val email = binding.etTextEmail.text.toString()
            val bundle = Bundle()
            bundle.putString("name", name)
            bundle.putString("email", email)

            if (email.isNotEmpty()) {
                findNavController().navigate(R.id.action_signUpEmailFragment_to_signUpPasswordFragment, bundle)
            } else {
                binding.textInputLayoutEmail.error = "Please enter your email"
            }
        }
        return binding.root
    }
}