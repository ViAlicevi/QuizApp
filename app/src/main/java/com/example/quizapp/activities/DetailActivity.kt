package com.example.quizapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.quizapp.R
import com.example.quizapp.data.Food
import com.example.quizapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickBack()

     //   val food = intent.getParcelableExtra<Food>(PostActivity.INTENT_PARCELABLE)
        showInformation()

       // imgSrc.setImageResource(food?.url!!)
//        imgTitle.text = food.foodName
//        imgDesc.text = food.Description

    }
    private fun showInformation() {
        val imageData = intent.getParcelableExtra<Food>(INTENT_PARCELABLE)

        with(binding) {
            Glide.with(imgDetail.context)
                .load(imageData?.url)
                .placeholder(R.drawable.ic_replay)
                .into(imgDetail)

            tvTwitterDetail.text = imageData?.Description

        }
    }
    private fun clickBack(){
        binding.imgBack.setOnClickListener {
            finish()
        }

    }
}