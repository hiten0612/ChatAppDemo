package com.example.chatappdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(private val chatList: ArrayList<ChatModel>,private val context: Context) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.chat_list,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val chatModel =  chatList[position]
        holder.txtUser.text = chatModel.message



    }

    override fun getItemCount(): Int {

        return chatList.size
    }

    class ViewHolder(itemView :View): RecyclerView.ViewHolder(itemView){

        val txtUser : TextView = itemView.findViewById(R.id.txtUser)

    }

}