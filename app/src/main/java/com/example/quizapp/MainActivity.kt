package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnStart.setOnClickListener {
           if (binding.edtName.text.toString().isEmpty()){
               binding.edtName.error = "Please enter your name"
           }

           if (binding.edtPass.text.toString().isEmpty()){
               binding.edtPass.error = "Please enter your password"
           }
           else if (binding.edtName.text.toString().isNotEmpty()&&binding.edtPass.text.toString().isNotEmpty()){
               val intent = Intent(this, QuizQuestionsActivity::class.java)
               intent.putExtra(Constants.USER_NAME, binding.edtName.toString())
               intent.putExtra(Constants.USER_PASSWORD, binding.edtPass.toString())
               startActivity(intent)
               finish()
           }

       }
        binding.tvSignin.setOnClickListener {
            val intent = Intent(this, RegisterAcitvity::class.java)
            startActivity(intent)
            finish()
        }



    }
}