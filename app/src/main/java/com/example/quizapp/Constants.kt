package com.example.quizapp

import com.example.quizapp.data.Question

object Constants {

    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestion(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()


        val que1 = Question(1, " Cái gì đen khi bạn mua nó, đỏ khi bạn sử dụng nó và khi vứt đi nó lại có màu xám xịt?",
            R.drawable.quizzzz,
            "Bật lửa",
            "Cây cối",
            "sắt",
            "Than",
            4
        )
        questionsList.add(que1)
        //question3
        val que2 = Question(2, "Cái gì mà bạn có, khi bạn chia sẻ với tôi, nhưng sau khi bạn chia sẻ bạn sẽ không còn có nó nữa??",
            R.drawable.quiz,
            "Bí mật",
            "Tiền",
            "Sức khỏe",
            "Ai mà biết",
            1
        )
        questionsList.add(que2)

        val que3 = Question(3, "Cái gì chặt không đứt, bứt không rời, phơi không khô, đốt không cháy? ",
            R.drawable.why_quest,
            "Lửa",
            "Nước",
            "Gió",
            "Củi",
            2
        )
        questionsList.add(que3)
        val que4 = Question(1, "Bệnh gì bác sĩ bó tay? ",
            R.drawable.funny_quiz,
            "Gãy tay",
            "Gãy chân",
            "Ung thư",
            "Tiểu đường",
            2
        )
        questionsList.add(que4)

        val que5 = Question(3, " Con gì ăn lửa với nước than?",
            R.drawable.looo,
            "Con chim",
            "con tàu",
            "con voi",
            "con mèo",
            2
        )
        questionsList.add(que5)
        val que6 = Question(3, "Con gấu trúc ao ước gì mà không có được? ",
            R.drawable.looo,
            "Chụp hình màu",
            "ăn măng trúc",
            "leo cây",
            "Bơi",
            1
        )
        questionsList.add(que6)

        return questionsList
    }

}