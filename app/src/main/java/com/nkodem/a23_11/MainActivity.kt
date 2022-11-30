package com.nkodem.a23_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fun main(ards: Array<String>){
            val rows = 2
            val columns = 2
            val odMatrix = arrayOf(intArrayOf(), intArrayOf())
            val doMatrix = arrayOf(intArrayOf(), intArrayOf())

            val sum = Array(rows) { IntArray(columns)}

        }
    }

    

}