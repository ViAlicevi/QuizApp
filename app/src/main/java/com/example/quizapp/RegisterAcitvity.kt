package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityRegisterAcitvityBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterAcitvity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterAcitvityBinding
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterAcitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignin.setOnClickListener {

            if(binding.phoneNumber.text.toString().isEmpty()){
                  binding.phoneNumber.error = "Please enter your phone"
            }
            if (binding.email.text.toString().isEmpty()){
                binding.email.error = "Please enter your email"
//                if (!Patterns.EMAIL_ADDRESS.matcher(binding.email).matches()){
//                    binding.email.error = "Invalid email format"
//                }
            }
            if (binding.etName.text.toString().isEmpty()){
                binding.etName.error = "Please enter your name"
            }
            if (binding.etPass.text.toString().isEmpty()){
                binding.etPass.error = "Please enter password"
                if (binding.etPass.length()<6){
                    binding.etPass.error = "Password must atleast 6 characters"
                }
            }
            else if (binding.phoneNumber.text.toString().isNotEmpty()
                &&binding.email.text.toString().isNotEmpty()
                &&binding.etName.text.toString().isNotEmpty()&&binding.etPass.text.toString().isNotEmpty()){
                val phonenumber: String = binding.phoneNumber.text.toString()
                val email: String = binding.email.text.toString()
                val name: String = binding.etName.text.toString()
                val pass: String = binding.etPass.text.toString()
                mAuth = FirebaseAuth.getInstance()
                mAuth.createUserWithEmailAndPassword(
                        email.trim(),
                        pass.trim(),
                    )
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}