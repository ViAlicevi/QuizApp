package com.example.quizapp

import android.provider.ContactsContract

object Constants {

    const val USER_NAME: String="user_name"
    const val USER_PASSWORD: String="user_password"
    const val USER_PHONE: String="user_phone"
    const val USER_EMAIL: String="user_email"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(1, "What country does this flag belong to?",
        R.drawable.vietnam,
            "Argentina",
            "Australia",
            "VietNam",
            "America",
            1
        )
        questionList.add(que1)

        val que2 = Question(2, "What country does this flag belong to?",
            R.drawable.vietnam,
            "Argentina",
            "Australia",
            "VietNam",
            "America",
            2
        )
        questionList.add(que2)
        //que3
        val que3 = Question(3, "What country does this flag belong to?",
            R.drawable.ic_launcher_background,
            "Argentina",
            "Australia",
            "VietNam",
            "America",
            3
        )
        questionList.add(que3)

        return questionList
    }
}