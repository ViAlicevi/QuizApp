package com.example.quizapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    companion object{
   //     private var email = ""
        private const val TOKEN = " "
        private const val RC_SIGN_IN = 100
        private const val TAG = "GOOG_SIGN_IN_TAG"
        fun newInstance() = MainActivity
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN


   //     printHasKey()

        logIn()
        signUp()
        forgotPassword()
      //  loginWithGoogle()



    }

//    private fun checkUser() {
//
//        val firebaseUser = firebaseAuth.currentUser
//        if (firebaseUser != null){
//            startActivity(Intent(this@MainActivity, SecondActivity::class.java))
//            finish()
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == RC_SIGN_IN){
//            Log.d(TAG, "onActivityResult: " )
//            val accounTask = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//
//                val account = accounTask.getResult(ApiException::class.java)
//                firebaseAuthWithGoogleAccount(account)
//
//            }catch (e: Exception){
//                Log.d(TAG, "onActivityResult: ${e.message}")
//            }
//        }
//    }
//
//    private fun firebaseAuthWithGoogleAccount(account: GoogleSignInAccount?) {
//
//        Log.d(TAG, "firebaseAuthWithGoogleAccount: begin firebase auth with google account")
//
//        val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)
//            firebaseAuth.signInWithCredential(credential)
//                .addOnSuccessListener { authResult ->
//
//                    Log.d(TAG, "firebaseAuthWithGoogleAccount: LoggedIn")
//
//                    val firebaseUser = firebaseAuth.currentUser
//
//                    val uid = firebaseAuth.uid
//                    val email = firebaseUser!!.email
//
//                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Uid: $uid")
//                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Email: $email")
//
//                    if (authResult.additionalUserInfo!!.isNewUser){
//                        Log.d(TAG, "firebaseAuthWithGoogleAccount: Account created...\n$email")
//                        Toast.makeText(this@MainActivity, "Account created...\n$email", Toast.LENGTH_SHORT).show()
//                    }else{
//                        Log.d(TAG, "firebaseAuthWithGoogleAccount: Existing user...\n$email")
//                        Toast.makeText(this@MainActivity, "LoggedIn...\n$email", Toast.LENGTH_SHORT).show()
//
//                    }
//                    startActivity(Intent(this@MainActivity, SecondActivity::class.java))
//                    finish()
//
//                }.addOnFailureListener {e ->
//                    Log.d(TAG, "firebaseAuthWithGoogleAccount: LoggIn Failed : ${e.message}")
//                    Toast.makeText(this@MainActivity, "LoggIn Failed ${e.message}", Toast.LENGTH_SHORT).show()
//                }
//    }

    private fun logIn(){


        binding.btnStart.setOnClickListener {

            val email = binding.edtName.text.toString().trim(){it <= ' '}
            val password = binding.edtPass.text.toString().trim(){it <= ' '}
            firebaseAuth = FirebaseAuth.getInstance()

            if (binding.edtName.text.toString().isEmpty()){
                binding.edtName.error = "Please enter your email"
            }

            if (binding.edtPass.text.toString().isEmpty()){
                binding.edtPass.error = "Please enter your password"
            }
            else{

                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        val user = firebaseAuth.currentUser
                        updateUI(user)
                    }else{
                        Log.d(TAG, "Login failed. ${task.exception}")
                        Toast.makeText(this, "Authentication failed. ${task.exception}", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        }
    }

    private fun forgotPassword(){

        binding.tvForgotpassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun signUp(){
        binding.tvSignin.setOnClickListener {
            val intent = Intent(this, RegisterAcitvity::class.java)
            startActivity(intent)
            finish()
        }

    }

//    private fun loginWithGoogle(){
//        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
//
//        firebaseAuth = FirebaseAuth.getInstance()
//        checkUser()
//
//        binding.googleLogin.setOnClickListener {
//            Log.d(TAG, "onCreate: ")
//            val intent = googleSignInClient.signInIntent
//            startActivityForResult(intent, RC_SIGN_IN)
//        }
//    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
            Log.d(TAG, "current user: $user")
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}