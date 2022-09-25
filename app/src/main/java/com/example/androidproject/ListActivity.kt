package com.example.androidproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {
    val TAG = "ListActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "created")
        setContentView(R.layout.activity_list)
        findViewById<Button>(R.id.list_activity_back_button).setOnClickListener{
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "restarted")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "paused")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "stopped")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "resumed")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "destroyed")
    }
}