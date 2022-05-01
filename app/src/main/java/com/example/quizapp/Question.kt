package com.example.quizapp

data class Question (
    val id: Int,
    val question: String? = null,
    val image: Int,
    val optionOne: String? = null,
    val optionTwo: String? = null,
    val optionThree: String? = null,
    val optionFour: String? = null,
    val correctAnswer: Int
)