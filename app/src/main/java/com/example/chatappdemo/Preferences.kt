package com.example.chatappdemo

import android.content.Context
import android.content.SharedPreferences

object Preferences {

    lateinit var preferences: SharedPreferences

    fun init(context: Context){
        preferences = context.getSharedPreferences("Chat",Context.MODE_PRIVATE)
    }

    fun saveLoginData(id: String?, email: String, password: String){

        val editor : SharedPreferences.Editor = preferences.edit()
        editor.putString("id",id)
        editor.putString("email",email)
        editor.putString("password",password)
        editor.apply()
    }
}