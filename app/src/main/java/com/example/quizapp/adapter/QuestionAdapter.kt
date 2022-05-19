package com.example.quizapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.data.Question

class QuestionAdapter(
    private val questionList: ArrayList<Question>
): RecyclerView.Adapter<QuestionAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = questionList[position]

        holder.question.text = currentitem.Questions

//        holder.name.text = currentitem.etName
//        holder.phone.text = currentitem.phoneNumber
//        holder.pass.text = currentitem.etPass

    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val question: TextView = itemView.findViewById(R.id.tv_quiz)
//        val name: TextView = itemView.findViewById(R.id.tv_quiz1)
//        val phone: TextView = itemView.findViewById(R.id.tv_quiz2)
//        val pass: TextView = itemView.findViewById(R.id.tv_quiz3)
    }
}