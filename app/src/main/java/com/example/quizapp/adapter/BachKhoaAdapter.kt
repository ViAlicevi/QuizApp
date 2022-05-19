package com.example.quizapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.data.BachKhoa
import com.google.firebase.database.ValueEventListener

class BachKhoaAdapter(
  var c: ValueEventListener,
    private val bkList: ArrayList<BachKhoa>,
    private val clickListener: (String) -> Unit
    ): RecyclerView.Adapter<BachKhoaAdapter.MyViewHolder>() {

      class MyViewHolder(itemView: View, clickAtPosition: (Int)-> Unit): RecyclerView.ViewHolder(itemView){
            val title: TextView = itemView.findViewById(R.id.item_bk)
            val textView: TextView = itemView.findViewById(R.id.item_bk)

            init {

                itemView.setOnClickListener {
                    clickAtPosition(adapterPosition)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder (LayoutInflater.from(parent.context).inflate(R.layout.item_bach_khoa,
            parent, false)){
            clickListener(bkList[it].toString())


        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = bkList[position]


        holder.title.text = currentitem.title

        holder.itemView.setOnClickListener {
            val muc = currentitem.Muc
            val cnt = currentitem.content

           clickListener(bkList[position].toString())

        }
    }

    override fun getItemCount() = bkList.size




}