package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.quizapp.databinding.ActivityLoginBinding
import com.example.quizapp.databinding.ActivityScoreBinding
import org.checkerframework.common.subtyping.qual.Bottom

class ScoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScoreBinding
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.score.setText("Congrats !!! Your Score is ${intent.getIntExtra("SCORE",0)}")

//        val intent = Intent(this,MainActivity::class.java)

        val buttonClick = findViewById<Button>(R.id.signout)
        buttonClick.setOnClickListener(View.OnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            finish()
        })
    }
}

//val buttonClick = findViewById<Button>(R.id.button_click)
//
//// Set a click listener for the button
//buttonClick.setOnClickListener {
//    // Create an Intent to start the SecondActivity
//    val intent = Intent(this, SecondActivity::class.java)
//    startActivity(intent)
//}