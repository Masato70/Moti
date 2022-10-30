package com.example.moti

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.moti.databinding.LoginFragmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlin.math.log


class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.d(TAG, "通過")
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signinBtn.setOnClickListener {
            Log.d(TAG, "アカウント作成・ログイン開始")
            signin()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun signin() {
        val email = binding.etAddress.text.toString()
        val password = binding.etPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { create ->
                if (create.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    findNavController().navigate(R.id.action_loginFragment_to_bottom_home)
                } else {
                    Log.w(TAG, "createUserWithEmail:failure")

                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { login ->
                            if (login.isSuccessful) {
                                Log.d(TAG, "signInWithEmail:success")
                                findNavController().navigate(R.id.action_loginFragment_to_bottom_home)
                            } else {
                                Log.w(TAG, "signInWithEmail:failure")
                            }
                        }
                }
            }
    }
}