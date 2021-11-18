package com.example.navigationcomponent.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.navigation_component.R
import com.example.navigationcomponent.viewmodel.LoginViewModel
import com.example.navigation_component.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        setUpData()
    }

    private fun setUpData() {
        binding.loginButton.setOnClickListener {
            var email = binding.textinputEmail.text.toString()
            var password = binding.textinputPassword.text.toString()
            if (email.isEmpty()) {
                binding.textinputEmail.error = "Please Enter Email"
            } else if (password.isEmpty()) {
                binding.textinputPassword.error = "Please Enter Password"
            } else {
                Navigation.findNavController(requireView())
                    .navigate(
                        R.id.action_loginFragment_to_homeFragment,
                        bundleOf(
                            "email" to email, "password" to password
                        )
                    )
            }

        }
    }

}