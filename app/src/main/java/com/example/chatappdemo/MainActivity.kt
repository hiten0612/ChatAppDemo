package com.example.chatappdemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var data: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseDatabase: FirebaseDatabase



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Preferences.init(this)
        auth = FirebaseAuth.getInstance()

        firebaseDatabase = FirebaseDatabase.getInstance()
        data = FirebaseDatabase.getInstance().reference


        btnLogin.setOnClickListener(View.OnClickListener {

            validate(etEmail.text.toString(), etPassword.text.toString())
            auth.createUserWithEmailAndPassword(etEmail.text.toString(), etPassword.text.toString())
                .addOnCompleteListener(this) { task ->


                    Toast.makeText(
                        this,
                        "createUserWithEmail:onComplete" + task.isSuccessful,
                        Toast.LENGTH_SHORT
                    ).show()
                    if (task.isSuccessful) {
                        data = firebaseDatabase.getReference("users")
                        val user = FirebaseAuth.getInstance().currentUser

                        val userId = user?.uid
                        val myUser = User(etEmail.text.toString(), etPassword.text.toString())


                        data.child(userId!!).setValue(myUser)
                        Preferences.saveLoginData(userId,etEmail.text.toString(),etPassword.text.toString())


                    } else {
                        Toast.makeText(
                            this,
                            "Authentication Failed" + task.exception,
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.e("MyTag", task.exception.toString())
                    }
                }

            val intent = Intent(this,MessageActivity::class.java)
            startActivity(intent)
        })


    }


    private fun validate(email: String, password: String) {

        if (etEmail.text.toString().trim().isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email)
                .matches()
        ) {

            Snackbar.make(constraint, "enter Email", Snackbar.LENGTH_SHORT).show()
        } else if (etPassword.text.toString().isEmpty()) {

            Snackbar.make(constraint, "enter Password", Snackbar.LENGTH_SHORT).show()
        }

    }

//    private fun writeNewUser(name: String,email: String) {
//
//        val user = User(name,email)
//        data.child("user").setValue(user)
//        data.child("email").setValue(email)
//    }


}