package com.example.myfirstapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExplicitActivity : AppCompatActivity() {

    private lateinit var textInput: EditText
    private lateinit var btnSendResult: Button
    private lateinit var btnReturnToMain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicit)

        textInput = findViewById<EditText>(R.id.textInput)
        btnSendResult = findViewById<Button>(R.id.btnSendResult)
        btnReturnToMain = findViewById<Button>(R.id.btnReturnToMain)

        btnReturnToMain.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSendResult.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("textValue", textInput.text.toString())
            startActivity(intent)
        }
    }
}