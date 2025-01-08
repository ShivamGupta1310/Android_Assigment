package com.example.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private val tutorials = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.listView)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, tutorials)
        listView.adapter = arrayAdapter

        // Add initial items in onCreate
        tutorials.add("onCreated called at: ${dateTime()}")
        arrayAdapter.notifyDataSetChanged()
    }

    override fun onStart() {
        super.onStart()
        tutorials.add("onStart called at: ${dateTime()}")
        arrayAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        tutorials.add("onResume called at: ${dateTime()}")
        arrayAdapter.notifyDataSetChanged()
    }

    override fun onPause() {
        super.onPause()
        tutorials.add("onPause called at: ${dateTime()}")
        arrayAdapter.notifyDataSetChanged()
    }

    override fun onStop() {
        super.onStop()
        tutorials.add("onStop called at: ${dateTime()}")
        arrayAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "App Kill", Toast.LENGTH_SHORT).show()
        tutorials.add("onDestroy called at: ${dateTime()}")
        arrayAdapter.notifyDataSetChanged()
    }

    fun onPressGrid(view: View) {
        val intent = Intent(applicationContext, GridActivity::class.java)
        intent.putExtra("listView", tutorials)
        startActivity(intent)
    }

    fun dateTime(): String {
        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
    }
}