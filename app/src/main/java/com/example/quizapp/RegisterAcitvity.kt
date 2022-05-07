package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityRegisterAcitvityBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class RegisterAcitvity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterAcitvityBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var database: DatabaseReference
   // private lateinit var firebaseUser: FirebaseUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterAcitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.tvHaveAccount.setOnClickListener {
            onBackPressed()
        }

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
                val phoneNumber: String = binding.phoneNumber.text.toString()
                val email: String = binding.email.text.toString()
                val etName: String = binding.etName.text.toString()
                val etPass: String = binding.etPass.text.toString()
                mAuth = FirebaseAuth.getInstance()
                mAuth.createUserWithEmailAndPassword(
                        email.trim(),
                        etPass.trim(),
                    )
                database = FirebaseDatabase.getInstance().getReference("Users")
                val User = User(phoneNumber, email, etName, etPass)
                database.child(etName).setValue(User).addOnSuccessListener {
                    binding.phoneNumber.text?.clear()
                    binding.email.text?.clear()
                    binding.etName.text?.clear()
                    binding.etPass.text?.clear()

                    Toast.makeText(this, "successfully saved", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(this, MainActivity::class.java)
//                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
//                intent.putExtra("user_id", firebaseUser.uid)
//                intent.putExtra("email_id", email)
                startActivity(intent)
                finish()
            }
        }
    }

}