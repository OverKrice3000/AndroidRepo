package com.example.androidproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button


class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "started")
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.main_activity_to_list_button).setOnClickListener {
            val intent = Intent(this, ListActivity::class.java);
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