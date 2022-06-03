package com.example.catagentprofile

import android.widget.ImageView
import android.widget.TextView

interface ImageLoader {
    fun loadImage(imageUrl: String, imageView: ImageView)
}