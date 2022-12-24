package com.example.moti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.moti.databinding.LoginEmailBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginPasswordFragment : Fragment() {

    private var _binding: LoginEmailBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btn_login = binding.btnLoginNext
        btn_login.setOnClickListener { findNavController().navigate(R.id.login_email_To_login_password) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun login_check() {
        val et_email_login = binding.etEmailLogin
        val et_pass_login = binding.


    }
}