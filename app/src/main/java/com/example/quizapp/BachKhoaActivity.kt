package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.adapter.BachKhoaAdapter
import com.example.quizapp.data.BachKhoa
import com.example.quizapp.databinding.ActivityBachKhoaBinding
import com.google.firebase.database.*

class BachKhoaActivity : AppCompatActivity() {
    private lateinit var dbref: DatabaseReference
    private lateinit var binding: ActivityBachKhoaBinding
    private lateinit var recyclerBK: RecyclerView
    private lateinit var arrayBkList: ArrayList<BachKhoa>

    private lateinit var bkAdapter: BachKhoaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBachKhoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerBK = binding.recyclerviewBk
        recyclerBK.layoutManager= LinearLayoutManager(this)
        recyclerBK.setHasFixedSize(true)
       arrayBkList = arrayListOf<BachKhoa>()


        getBachKhoaData()

    }

    private fun getBachKhoaData() {

        dbref = FirebaseDatabase.getInstance().getReference("BachKhoaCuocSong")
        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (bachkhoaSnapshot in snapshot.children){
                        val bachkhoa = bachkhoaSnapshot.getValue(BachKhoa::class.java)

                        arrayBkList.add(bachkhoa!!)
                    }
                    recyclerBK.adapter = BachKhoaAdapter(this, arrayBkList){
                        Toast.makeText(this@BachKhoaActivity, it, Toast.LENGTH_LONG).show()
//

                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@BachKhoaActivity, error.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

}