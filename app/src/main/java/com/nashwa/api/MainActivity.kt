package com.nashwa.api

import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.nashwa.api.api.ApiClient
import com.nashwa.api.model.RegisterRequest
import com.nashwa.api.model.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var btnRegister : Button
    private lateinit var btnLogin : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegister = findViewById(R.id.btnRegister)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener(){
            startActivity(Intent(this, LoginActivity::class.java))
        }

        //kehalaman register
        btnRegister.setOnClickListener(){
            startActivity(Intent(this, RegisterActivity::class.java))
        }

    }
}