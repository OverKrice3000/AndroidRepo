package com.example.androidproject

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity";

    class ListFragment: Fragment(R.layout.fragment_list) {
        private fun onClickOnFragmentButton(id: String){
            val args = Bundle();
            args.putString(ItemFragment.ARG_ID, id);
            println(args.getString(ItemFragment.ARG_ID))
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container_item, ItemFragment::class.java, args)
                ?.addToBackStack(null)
                ?.commit()
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = super.onCreateView(inflater, container, savedInstanceState);
            view?.findViewById<View>(R.id.button_a)?.setOnClickListener { v ->
                run {
                    onClickOnFragmentButton("A")
                }
            };
            view?.findViewById<View>(R.id.button_b)?.setOnClickListener { v ->
                run {
                    onClickOnFragmentButton("B")
                }
            };
            view?.findViewById<View>(R.id.button_c)?.setOnClickListener { v ->
                run {
                    onClickOnFragmentButton("C")
                }
            };
            return view;
        }
    }

    class ItemFragment: Fragment(R.layout.fragment_item) {
        companion object {
            var ARG_ID : String = "btn_id";
            var TAG: String = "ItemFragment";
        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {

            val view = super.onCreateView(inflater, container, savedInstanceState) as TextView
            val id: String? = this.arguments?.getString(ARG_ID)
            view.text = id;
            return view;
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "started")
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.container_list, ListFragment::class.java, Bundle())
                .commit();
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