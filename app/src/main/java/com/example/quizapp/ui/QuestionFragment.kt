package com.example.quizapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizapp.BachKhoaActivity
import com.example.quizapp.KindQuestionActivity
import com.example.quizapp.QuizQuestionsActivity
import com.example.quizapp.SecretActivity
import com.example.quizapp.databinding.FragmentQuestionBinding


class QuestionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentQuestionBinding.inflate(layoutInflater)

        bind.tvQuiz.setOnClickListener {
            val intent = Intent(this@QuestionFragment.requireContext(), QuizQuestionsActivity::class.java)

            startActivity(intent)
        }
        bind.imageQuiz.setOnClickListener {
            val intent = Intent(this@QuestionFragment.requireContext(), KindQuestionActivity::class.java)
            startActivity(intent)
        }
        bind.imageQuiz3.setOnClickListener {
            val intent = Intent(this@QuestionFragment.requireContext(), BachKhoaActivity::class.java)
            startActivity(intent)
        }
        bind.tvQuiz4.setOnClickListener {
            val intent = Intent(this@QuestionFragment.requireContext(), SecretActivity::class.java)
            startActivity(intent)
        }

        return bind.root
    }
}