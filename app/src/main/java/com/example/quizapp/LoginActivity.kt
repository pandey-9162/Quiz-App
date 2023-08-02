package com.example.quizapp

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.ktx.Firebase

private var Drawable.Callback.isSuccessful: Boolean
    get() {
        TODO("Not yet implemented")
    }
    set(value) {}

class LoginActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()
        binding.button.setOnClickListener{
            this.firebaseAuth.createUserWithEmailAndPassword(binding.email.editableText.toString(),binding.password.editableText.toString()).addOnCompleteListener(){
                if(it.isSuccessful){
                    Toast.makeText(this,"User Created !!! ", Toast.LENGTH_LONG).show()
                }
                else{
                    Toast.makeText(this, "User Not Created !!! ", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
