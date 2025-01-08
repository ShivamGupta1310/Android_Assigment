package com.example.activitylifecycle

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class GridActivity : AppCompatActivity() {
    private var listViewData: ArrayList<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_grid)
        val gridView = findViewById<GridView>(R.id.gridView)
        listViewData = intent.getStringArrayListExtra("listView")
        if (listViewData != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewData!!)
            gridView.adapter = adapter
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun onPressShareButton(view: View) {
        val currentListViewData = listViewData
        if (currentListViewData.isNullOrEmpty()) {
            Toast.makeText(this, "No data to share!", Toast.LENGTH_SHORT).show()
            return
        }
        val shareText = currentListViewData.joinToString(separator = "\n")
        Intent(Intent.ACTION_SEND).apply { type }
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}