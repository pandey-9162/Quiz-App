package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityLoginBinding
import com.example.quizapp.databinding.ActivityQuizBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    private lateinit var firestore: FirebaseFirestore
    lateinit var list: ArrayList<QuestionModel>
    private var count:Int = 0
    private var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        firestore = FirebaseFirestore.getInstance()
        setContentView(binding.root)
        list = ArrayList<QuestionModel>()
        firestore.collection("quiz").get().addOnSuccessListener {
                doct->
            list.clear()
            for (i in doct.documents)
            {
                var questionModel=i.toObject(QuestionModel::class.java)
                list.add(questionModel!!)
            }
            binding.question.setText(list.get(0).question)
            binding.option1.setText(list.get(0).option1)
            binding.option2.setText(list.get(0).option2)
            binding.option3.setText(list.get(0).option3)
            binding.option4.setText(list.get(0).option4)
        }
//        list.add(QuestionModel("Who is the PM of India?","Modi ji","Yogi ji","Amit ji","Rahul ji","Modi ji"))
//        list.add(QuestionModel("Who is the CM of West Bengal?","Mamta ji","Yogi ji","Amit ji","Rahul ji","Mamta ji"))
//        list.add(QuestionModel("Who is the Home Minister of India?","Yogi ji","Modi ji","Amit ji","Rahul ji","Amit ji"))
//        list.add(QuestionModel("Who is the Defence Minister of India?","Shri Rajnath Singh ji","Yogi ji","Modi ji","Amit ji","Shri Rajnath Singh ji"))
//        list.add(QuestionModel("Who is the VP of India?","Modi ji","Jagdeep Dhankhar ji","Amit ji","Rahul ji","Jagdeep Dhankhar ji"))

        binding.option1.setOnClickListener {
            nextData(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            nextData(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            nextData(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener {
            nextData(binding.option4.text.toString())
        }
    }

    private fun nextData(i: String) {
        if(count<list.size) {
            if (list.get(count).ans.equals(i)) {
                score++
            }
        }
        count++
        if(count>=list.size)
        {
            val intent = Intent(this,ScoreActivity::class.java)
            intent.putExtra("SCORE",score)
            startActivity(intent)
            finish()
        }
        else {
            binding.question.setText(list.get(count).question)
            binding.option1.setText(list.get(count).option1)
            binding.option2.setText(list.get(count).option2)
            binding.option3.setText(list.get(count).option3)
            binding.option4.setText(list.get(count).option4)
        }
    }
}


//package com.example.quizapp
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import com.example.quizapp.databinding.ActivityLoginBinding
//import com.example.quizapp.databinding.ActivityQuizBinding
////import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.ktx.Firebase
//
//class QuizActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityQuizBinding
////    private lateinit var firestore: FirebaseFirestore
//    lateinit var list: ArrayList<QuestionModel>
//    private var count:Int = 0
//    private var score = 0
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityQuizBinding.inflate(layoutInflater)
////        firestore = FirebaseFirestore.getInstance()
//        setContentView(binding.root)
//
////        firestore.collection("quiz").get().addOnSuccessListener {
////                doct->
////            list.clear()
////            for (i in doct.documents)
////            {
////
////                var questionModel=i.toObject(QuestionModel::class.java)
////                list.add(questionModel!!)
////            }
//
////        }
//            list = ArrayList<QuestionModel>()
//        list.add(QuestionModel("Who is the PM of India?","Modi ji","Yogi ji","Amit ji","Rahul ji","Modi ji"))
//        list.add(QuestionModel("Who is the CM of West Bengal?","Mamta ji","Yogi ji","Amit ji","Rahul ji","Mamta ji"))
//        list.add(QuestionModel("Who is the Home Minister of India?","Yogi ji","Modi ji","Amit ji","Rahul ji","Amit ji"))
//        list.add(QuestionModel("Who is the Defence Minister of India?","Shri Rajnath Singh ji","Yogi ji","Modi ji","Amit ji","Shri Rajnath Singh ji"))
//        list.add(QuestionModel("Who is the VP of India?","Modi ji","Jagdeep Dhankhar ji","Amit ji","Rahul ji","Jagdeep Dhankhar ji"))
//
//        binding.question.setText(list.get(0).question)
//        binding.option1.setText(list.get(0).option1)
//        binding.option2.setText(list.get(0).option2)
//        binding.option3.setText(list.get(0).option3)
//        binding.option4.setText(list.get(0).option4)
//
//        binding.option1.setOnClickListener {
//            nextData(1)
//        }
//        binding.option2.setOnClickListener {
//            nextData(2)
//        }
//        binding.option3.setOnClickListener {
//            nextData(3)
//        }
//        binding.option4.setOnClickListener {
//            nextData(4)
//        }
//    }
//    private fun nextData(i: Int) {
//        count++
//        binding.question.setText(list.get(count).question)
//        binding.option1.setText(list.get(count).option1)
//        binding.option2.setText(list.get(count).option2)
//        binding.option3.setText(list.get(count).option3)
//        binding.option4.setText(list.get(count).option4)
//    }
///*
//    private fun nextData(i: String) {
//        if(count<list.size) {
//            if (list.get(count).ans.equals(i)) {
//                score++
//            }
//        }
//        count++
//        if(count>=list.size)
//        {
//            val intent = Intent(this,ScoreActivity::class.java)
//            intent.putExtra("SCORE",score)
//            startActivity(intent)
//            finish()
//        }
//        else {
//            binding.question.setText(list.get(count).question)
//            binding.option1.setText(list.get(count).option1)
//            binding.option2.setText(list.get(count).option2)
//            binding.option3.setText(list.get(count).option3)
//            binding.option4.setText(list.get(count).option4)
//        }
//    }*/
//}

