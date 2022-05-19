package com.example.quizapp.adapter

import com.example.quizapp.R
import com.example.quizapp.data.Question

object KindQuestion {

    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestion(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()


        val que1 = Question(1, "Đảo Síp thuộc Châu lục nào? ",
            R.drawable.why_quest,
            "Châu Mĩ",
            "Châu Âu",
            "Châu Úc",
            "Châu Á",
            4
        )
        questionsList.add(que1)
        //question3
        val que2 = Question(2, "Quốc gia nào nhỏ nhất về diện tích?",
            R.drawable.quiz,
            "Vatican",
            "Việt Nam",
            "Chile",
            "Brunei",
            1
        )
        questionsList.add(que2)

        val que3 = Question(3, "Thành phố Châu Âu nào được gọi là thành phố vĩnh cửu? ",
            R.drawable.quiz,
            "Paris",
            "Roma",
            "London",
            "MiLan",
            2
        )
        questionsList.add(que3)
        val que4 = Question(1, "Hồ nội địa nào sâu nhất thế giới? ",
            R.drawable.quizzzz,
            "Hồ Bai Can ở Nga",
            "Hồ Ba Bể",
            "Hồ Tây",
            "Hồ Xuân Hương",
            1
        )
        questionsList.add(que4)

        val que5 = Question(3, "Cảng nào lớn nhất Đông Á?",
            R.drawable.quiz,
            "Cảng Thượng Hải",
            "Cảng Singarpo",
            "Cảng Sài Gòn",
            "Cảng Hải Phòng",
            1
        )
        questionsList.add(que5)
        val que6 = Question(3, "Người ta gọi vùng rừng đai Siberi là ? ",
            R.drawable.looo,
            "Rừng Amazone",
            "Rừng Tai Can",
            "Rừng Everest",
            "Rừng lạnh",
            2
        )
        questionsList.add(que6)

        return questionsList
    }


}