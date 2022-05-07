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

        val que1 = Question(1, "Which of following protocol is HTTP built upon? ",
        R.drawable.vietnam,
            "TCP " ,
            "UDP",
            "IP " ,
            "ICMP ",
            1
        )
        questionList.add(que1)

        val que2 = Question(2, "  What was the concern of the telephone system that motivated the ARPANET design? ",
            R.drawable.vietnam,
            "Vulnerability",
            "Scalability",
            "Efficiency",
            "None of the mentioned ",
            1
        )
        questionList.add(que2)
        //que3
        val que3 = Question(3, "Which of following requirements are necessary for packet networks to support multiple and diverse applications? ",
            R.drawable.ic_launcher_background,
            "Transfer arbitrary message size ",
            "All of the mentioned ",
            "Low delay for interfactive applications ",
            "Packets have maximum length ",
            2
        )
        questionList.add(que3)

        val que4 = Question(4, "Which of the following is an application layer protocol?  ",
            R.drawable.ic_launcher_background,
            "DNS",
            "HTTP",
            "UDP",
            "TCP",
            2
        )
        questionList.add(que4)

        return questionList
    }
}