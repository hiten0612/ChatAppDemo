package com.example.chatappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_chat.*

class MessageActivity : AppCompatActivity() {


    private var chatAdapter: ChatAdapter? = null
    private var chat = ArrayList<ChatModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)


        chat.add(ChatModel(1,"hiten1@gmail.com","hii good morning1"))
        chat.add(ChatModel(2,"hiten12@gmail.com","hii good morning12"))
        chat.add(ChatModel(3,"hiten123@gmail.com","hii good morning123"))
        chat.add(ChatModel(4,"hiten1234@gmail.com","hii good morning1234"))
        chat.add(ChatModel(5,"hiten12345@gmail.com","hii good morning12345"))


        recyclerView.layoutManager = LinearLayoutManager(this)
        chatAdapter = ChatAdapter(chat,this)
        recyclerView.adapter = chatAdapter


    }
}