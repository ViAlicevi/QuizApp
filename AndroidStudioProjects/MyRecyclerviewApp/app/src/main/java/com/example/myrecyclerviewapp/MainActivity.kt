package com.example.myrecyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myrecyclerviewapp.model.EmployeeRole
import com.example.myrecyclerviewapp.model.EmployeeUiModel
import com.example.myrecyclerviewapp.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val employeesAdapter by lazy{
        EmployeesAdapter(layoutInflater, GlideImageLoader(this))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = employeesAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        employeesAdapter.setData(
            listOf(EmployeeUiModel(
                "Fred",
                EmployeeRole.HumanResources,
                Gender.Female,
                "https://cdn2.thecatapi.com/images/DBmIBhhyv.jpg"
            ),
            EmployeeUiModel(
                "Jenny",
                EmployeeRole.Management,
                Gender.Male,
                "https://cdn2.thecatapi.com/images/KJF8fB_20.jpg"
                ),
            EmployeeUiModel(
                "Curious George",
                EmployeeRole.Technology,
                Gender.Unknown,
                "https://cdn2.thecatapi.com/images/vJB8rwfdX.jpg"
            )
            )
        )
    }
}