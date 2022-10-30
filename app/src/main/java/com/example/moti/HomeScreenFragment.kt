package com.example.moti

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class HomeScreenFragment : Fragment() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_screen_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()
        signinCheck()
    }

    private fun signinCheck() {
        val currentUser = auth.currentUser
        if(currentUser == null){
            Log.d(TAG, "ログインしてません")
            findNavController().navigate(R.id.action_bottom_home_to_loginFragment)
        } else if(currentUser != null) {
            Log.d(TAG, "ログインしてます")
        }
    }
}