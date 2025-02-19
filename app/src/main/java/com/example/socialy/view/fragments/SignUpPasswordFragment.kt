package com.example.socialy.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.socialy.R
import com.example.socialy.databinding.FragmentSignUpPasswordBinding
import com.example.socialy.view.activities.HomeActivity
import com.example.socialy.viewmodel.AuthViewModel

class SignUpPasswordFragment : Fragment() {
    private lateinit var binding: FragmentSignUpPasswordBinding
    private lateinit var authViewModel: AuthViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpPasswordBinding.inflate(inflater, container, false)
        authViewModel = context?.applicationContext?.let { AuthViewModel(it) }!!
        binding.btnBackSignUpPassword.setOnClickListener {
            findNavController().navigate(R.id.action_signUpPasswordFragment_to_signUpEmailFragment)
        }

        val name = arguments?.getString("name")
        val email = arguments?.getString("email")

        binding.btnNextSignUpPassword.setOnClickListener {
            val password = binding.etTextPassword.text.toString()
            if (password.isNotEmpty()) {
                binding.progressBarSignUp.visibility = View.VISIBLE
                authViewModel.signUp(name!!, email!!, password)
                val intent = Intent(context, HomeActivity::class.java)
                startActivity(intent)
                activity?.finishAffinity()
            } else {
                binding.textInputLayoutPassword.error = "Please enter your password"
            }
        }
        return binding.root
    }
}