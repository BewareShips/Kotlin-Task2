package com.example.inputanddisplay

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private var clickCountMap = mutableMapOf<String,Int>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayView = findViewById<TextView>(R.id.clickTextView)
        val clickCountBtn = findViewById<TextView>(R.id.clickedCountBtn)
        val userNameTextInputView = findViewById<TextInputLayout>(R.id.filledTextField)



        clickCountBtn.setOnClickListener{
            val userName = userNameTextInputView.editText?.text?.toString()
            val madeUserName = if(userName.isNullOrEmpty()){"Somebody"}  else userName

            val oldClickCount = clickCountMap[madeUserName] ?: 0
            val newClickCount = oldClickCount + 1

            clickCountMap[madeUserName] = newClickCount
            clickCountDisplayView.text = "$madeUserName Clicked $newClickCount  times"
        }
    }
}