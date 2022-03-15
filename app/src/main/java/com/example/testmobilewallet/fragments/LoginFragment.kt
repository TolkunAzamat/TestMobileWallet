package com.example.testmobilewallet.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testmobilewallet.HomeActivity
import com.example.testmobilewallet.MainActivity
import com.example.testmobilewallet.R
import com.example.testmobilewallet.SharedPreference
import com.example.testmobilewallet.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val sharedPref = context?.let { SharedPreference(it) }
        if (!sharedPref?.login.isNullOrBlank() && !sharedPref?.password.isNullOrBlank()) {
            startActivity(Intent(requireActivity(), HomeActivity::class.java))
       }
        _binding = FragmentLoginBinding.inflate(inflater, container, false)


        binding.btnlog.setOnClickListener {
            sharedPref?.login = binding.editlog.text.toString()
            sharedPref?.password = binding.editpass.text.toString()
            startActivity(Intent(requireActivity(), HomeActivity::class.java))


            val arg =requireActivity().getSharedPreferences("SharedPreference", Context.MODE_PRIVATE)
                ?.apply {
                    val login = getString("login", null)
                    val password = getString("password", null)
                    binding.editlog.setText(login)
                    binding.editpass.setText(password)
                }
        }
        return binding.root
    }

}