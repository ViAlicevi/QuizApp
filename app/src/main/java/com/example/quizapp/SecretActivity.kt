package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.adapter.BachKhoaAdapter
import com.example.quizapp.adapter.SecretAdapter
import com.example.quizapp.data.Secret
import com.example.quizapp.databinding.ActivityBachKhoaBinding
import com.example.quizapp.databinding.ActivitySecretBinding
import com.google.firebase.database.*

class SecretActivity : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var binding: ActivitySecretBinding
    private lateinit var recyclerSecret: RecyclerView
    private lateinit var arraySecretList: ArrayList<Secret>

    private lateinit var secretAdapter: SecretAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecretBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerSecret = binding.recyclerviewSecret
        recyclerSecret.layoutManager = LinearLayoutManager(this)
        recyclerSecret.setHasFixedSize(true)
        arraySecretList = arrayListOf<Secret>()

        getSecretData()
    }

    private fun getSecretData() {

        dbref = FirebaseDatabase.getInstance().getReference("BachKhoaCuocSong")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (secretSnapshot in snapshot.children){
                        val secret = secretSnapshot.getValue(Secret::class.java)

                      arraySecretList.add(secret!!)

                    }
                    recyclerSecret.adapter = SecretAdapter(arraySecretList){
                        Toast.makeText(this@SecretActivity, it, Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

    }
}