package com.example.socialy.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.socialy.R
import com.example.socialy.databinding.FragmentSignUpPasswordBinding

class SignUpPasswordFragment : Fragment() {
    private lateinit var binding: FragmentSignUpPasswordBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpPasswordBinding.inflate(inflater, container, false)
        binding.btnBackSignUpPassword.setOnClickListener {
            findNavController().navigate(R.id.action_signUpPasswordFragment_to_signUpEmailFragment)
        }
        return binding.root
    }
}