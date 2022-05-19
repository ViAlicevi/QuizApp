package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizapp.adapter.KindQuestion
import com.example.quizapp.data.Question
import com.example.quizapp.databinding.ActivityKindQuestionBinding
import com.example.quizapp.databinding.ActivityQuizQuestionsBinding
class KindQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    private lateinit var binding: ActivityKindQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKindQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mQuestionsList = KindQuestion.getQuestion()


        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)

        binding.btnSubmit.setOnClickListener(this)
        setQuestion()

    }
    private fun setQuestion(){
        //  mCurrentPosition = 1

        defaultOptionsView()

        val question = mQuestionsList!![mCurrentPosition -1]

        binding.tvQuestion.text = question.Questions
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour

        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition"+ "/"+ binding.progressBar.max


        if (mCurrentPosition == mQuestionsList!!.size){
            binding.btnSubmit.text = "Finish"
        }
        else{
            binding.btnSubmit.text = "Submit"

        }

    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, binding.tvOptionOne)
        options.add(1, binding.tvOptionTwo)
        options.add(2, binding.tvOptionThree)
        options.add(3, binding.tvOptionFour)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(p0: View?) {

        when(p0?.id){
            R.id.tv_option_one ->{
                selectedOptionView(binding.tvOptionOne, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(binding.tvOptionTwo, 2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(binding.tvOptionThree, 3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(binding.tvOptionFour, 4)
            }
            R.id.btn_submit ->{
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition == mQuestionsList!!.size ->{


                            val intent = Intent(this@KindQuestionActivity, ResultActivity::class.java)
                            intent.putExtra(KindQuestion.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(KindQuestion.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)

                        }else ->{

                        setQuestion()

                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++

                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if (mCurrentPosition <= mQuestionsList!!.size){
                        binding.btnSubmit.text = "Go to next question"
                    }else{
                        binding.btnSubmit.text = "Finish"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }
    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }
    private fun answerView(answer: Int?, drawableView: Int){
        when(answer){
            1 ->{
                binding.tvOptionOne.background = ContextCompat.getDrawable(
                    this, drawableView)
            }
            2 ->{
                binding.tvOptionTwo.background = ContextCompat.getDrawable(
                    this, drawableView)
            }
            3 ->{
                binding.tvOptionThree.background = ContextCompat.getDrawable(
                    this, drawableView)
            }
            4 ->{
                binding.tvOptionFour.background = ContextCompat.getDrawable(
                    this, drawableView)
            }
        }
    }
}