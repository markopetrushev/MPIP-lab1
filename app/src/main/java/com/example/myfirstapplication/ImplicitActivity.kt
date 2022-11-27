package com.example.myfirstapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ImplicitActivity : AppCompatActivity(){
    override fun onCreate(saverInstanceState: Bundle?) {
        super.onCreate(saverInstanceState)
        setContentView(R.layout.activity_implicit)

        val mainIntent = Intent(Intent.ACTION_MAIN, null)

        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)

        val OSActivities = packageManager.queryIntentActivities(mainIntent, 0)
        var activities = arrayOf<String>()
        for (i in OSActivities.indices) {
            activities += OSActivities[i].activityInfo.name
        }

        val arrayAdapter: ArrayAdapter<*>

        var list = findViewById<ListView>(R.id.list)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, activities)
        list.adapter = arrayAdapter
    }
}