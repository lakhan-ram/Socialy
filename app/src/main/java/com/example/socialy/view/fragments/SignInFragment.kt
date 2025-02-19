package com.example.socialy.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.socialy.R
import com.example.socialy.databinding.FragmentSignInBinding
import com.example.socialy.view.activities.HomeActivity
import com.example.socialy.viewmodel.AuthViewModel

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var authViewModel: AuthViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        binding.btnBackSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_signInFragment_to_welcomeFragment)
        }

        authViewModel = context?.let { AuthViewModel(it.applicationContext) }!!
        authViewModel.authList.observe(viewLifecycleOwner) {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
            activity?.finishAffinity()
        }
        binding.btnSignIn.setOnClickListener {
            val email = binding.etTextEmailSignIn.text.toString()
            val password = binding.etTextPasswordSignIn.text.toString()

            if (email.isEmpty() && password.isEmpty()) {
                binding.textInputLayoutEmailSignIn.error = "Please enter your email"
                binding.textInputLayoutPasswordSignIn.error = "Please enter your password"
            }
            if (email.isEmpty()) {
                binding.textInputLayoutEmailSignIn.error = "Please enter your email"
            }
            if (password.isEmpty()) {
                binding.textInputLayoutPasswordSignIn.error = "Please enter your password"
            }
            if (email.isNotEmpty() && password.isNotEmpty()) {
                binding.progressBarSignIn.visibility = View.VISIBLE
                authViewModel.signIn(email, password)
            }
        }

        return binding.root
    }
}