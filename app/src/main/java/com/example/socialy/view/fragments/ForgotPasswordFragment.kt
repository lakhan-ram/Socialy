package com.example.socialy.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.socialy.R
import com.example.socialy.databinding.FragmentForgotPasswordBinding
import com.example.socialy.viewmodel.AuthViewModel

class ForgotPasswordFragment : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding
    private lateinit var authViewModel: AuthViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        binding.btnBackForgotPass.setOnClickListener {
            findNavController().navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
        }
        authViewModel = context?.let { AuthViewModel(it.applicationContext) }!!
        binding.btnSend.setOnClickListener {
            val email = binding.etTextEmailForgotPass.text.toString()
            if (email.isNotEmpty()) {
                authViewModel.resetPassword(email)
                findNavController().navigate(R.id.action_forgotPasswordFragment_to_signInFragment)
            } else {
                binding.textInputLayoutEmailForgotPass.error = "Please enter your email"
            }
        }
        return binding.root
    }
}