package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

       binding.btnStart.setOnClickListener {
           if (binding.edtName.text.toString().isEmpty()){
               binding.edtName.error = "Please enter your name"
           }

           if (binding.edtPass.text.toString().isEmpty()){
               binding.edtPass.error = "Please enter your password"
           }
           else if (binding.edtName.text.toString().isNotEmpty()&&binding.edtPass.text.toString().isNotEmpty()){
               val intent = Intent(this, SecondActivity::class.java)
//               intent.putExtra(Constants.USER_NAME, binding.edtName.toString())
//               intent.putExtra(Constants.USER_PASSWORD, binding.edtPass.toString())
               intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
               intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
               startActivity(intent)
               finish()
           }

       }
        binding.tvSignin.setOnClickListener {
            val intent = Intent(this, RegisterAcitvity::class.java)
            startActivity(intent)
            finish()
        }
        binding.tvForgotpassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
//    private fun checkUser(){
//        val intent = Intent(this, )
//        val firebaseUser = FirebaseAuth.currentUser
//        if (firebaseUser != null){
//            startActivity()
//        }
//    }
}