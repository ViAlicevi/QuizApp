package com.example.quizapp.data

data class Question(
    val id: Int?,
    val Questions: String? = null,
    val image: Int,
    val optionOne: String? = null,
    val optionTwo: String? = null,
    val optionThree: String? = null,
    val optionFour: String? = null,
    val correctAnswer: Int?
) {

}