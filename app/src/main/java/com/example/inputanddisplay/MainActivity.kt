package com.example.inputanddisplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    var clickCountMap = mutableMapOf<String,Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickCountDisplayView = findViewById<TextView>(R.id.clickTextView)
        val clickCountBtn = findViewById<Button>(R.id.clickedCountBtn)
        val inputName = findViewById<TextInputLayout>(R.id.inputName)

        clickCountBtn.setOnClickListener{
            val userName = inputName.editText?.text?.toString()
            val makedUserName = if(userName.isNullOrEmpty()){"Somebody"}  else userName

            val oldClickCount = clickCountMap[makedUserName] ?: 0
            val newClickCount = oldClickCount + 1

            clickCountMap[makedUserName] = newClickCount
            clickCountDisplayView.text = "$makedUserName Clicked $newClickCount  times"
        }
    }
}