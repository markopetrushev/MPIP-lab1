package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var explicitActivityResult: TextView
    private lateinit var btnGoToExplicitActivity: Button
    private lateinit var btnGoToImplicitActivity: Button
    private lateinit var btnSendData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        explicitActivityResult = findViewById(R.id.explicitActivityResult)
        btnGoToExplicitActivity = findViewById<Button>(R.id.buttonToExplicit)
        btnGoToImplicitActivity = findViewById<Button>(R.id.buttonToImplicit)
        btnSendData = findViewById(R.id.buttonSendData)

        val bundle: Bundle? = intent.extras
        val textValue: String = bundle?.get("textValue").toString()

        explicitActivityResult.text = textValue

        btnGoToExplicitActivity.setOnClickListener {
            val intent: Intent = Intent(this, ExplicitActivity::class.java)
            startActivity(intent)
        }

        btnGoToImplicitActivity.setOnClickListener{
            val intent: Intent = Intent(this, ImplicitActivity::class.java)
            startActivity(Intent.createChooser(intent, "Choose app for intent"))
        }

        btnSendData.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).let { intent ->
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_SUBJECT, "MPiP Send Title")
                intent.putExtra(Intent.EXTRA_TEXT, "Content send from MainActivity")
                startActivity(intent)
            }
        }
    }
}