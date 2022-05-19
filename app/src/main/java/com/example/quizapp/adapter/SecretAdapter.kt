package com.example.quizapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.data.Secret

class SecretAdapter(private val secretList: ArrayList<Secret>,
                   private val clickListener: (String) -> Unit): RecyclerView.Adapter<SecretAdapter.MyViewHolder>()
{
    class MyViewHolder(itemView: View, clickAtPosition: (Int) -> Unit): RecyclerView.ViewHolder(itemView) {
         val ct: TextView = itemView.findViewById(R.id.item_secret)

         val textView: TextView = itemView.findViewById(R.id.item_secret)

        init {
            itemView.setOnClickListener {
                clickAtPosition(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_secret, parent, false)){
            clickListener(secretList[it].toString())
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = secretList[position]

        holder.ct.text = currentitem.Bian
        holder.itemView.setOnClickListener {
            clickListener(secretList[position].toString())
        }
    }

    override fun getItemCount() = secretList.size

}