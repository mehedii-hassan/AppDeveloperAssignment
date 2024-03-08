package com.example.appdeveloperassignment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.appdeveloperassignment.R
import com.example.appdeveloperassignment.databinding.FragmentLoginBinding
import com.example.appdeveloperassignment.ui.utils.SharedPrefManager


class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        //initialization
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        SharedPrefManager.clearFilteredJobList(requireContext())
        binding.btnLogin.setOnClickListener {
            userLogin()
        }
    }

    private fun userLogin() {
        val name = binding.etUserName.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        if (name.isEmpty() || password.isEmpty()) {
            Toast.makeText(context, "Pls fill all the field properly", Toast.LENGTH_LONG).show()
            return
        }

        if (name == "Admin" && password == "Admin@123") {
            Navigation.findNavController(requireView())
                .navigate(R.id.actionLoginToBookLibraryFragment)
            Toast.makeText(context, "successfully logged in", Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(
                context,
                "user name should be Admin and password should be Admin@123",
                Toast.LENGTH_LONG
            ).show()

        }
    }
}