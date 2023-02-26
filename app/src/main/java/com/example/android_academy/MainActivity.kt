package com.example.android_academy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.button)
        val helloText : TextView = findViewById(R.id.HelloText)

        btn.setOnClickListener{
            if (btn.text == "HIDE TEXT"){
                helloText.text = ""
                btn.text = "SHOW TEXT"
            } else if (btn.text == "SHOW TEXT"){
                helloText.text = "Hello World!"
                btn.text = "HIDE TEXT"
            }
        }
    }
}