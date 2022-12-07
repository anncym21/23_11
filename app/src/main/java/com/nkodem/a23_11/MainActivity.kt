package com.nkodem.a23_11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rarity = resources.getStringArray(R.array.dystans)
        val randomRarity = rarity.random()
        val zmien = findViewById(R.id.zmien) as Button
        val dystans = findViewById(R.id.dystans) as TextView

        zmien.setOnClickListener {
                dystans.setText(randomRarity)
        }

        fun main(ards: Array<String>){
            val rows = 2
            val columns = 2
            val odMatrix = arrayOf(intArrayOf(), intArrayOf())
            val doMatrix = arrayOf(intArrayOf(), intArrayOf())

            val sum = Array(rows){ IntArray(columns)}
            for(i in 0..columns - 1){
                for(j in 0..columns - 1){
                    sum[i][j] = odMatrix[i][j] + doMatrix[i][j]
                }
            }
            println("suma.: ")
            for(row in sum){
                for(columns in row){
                    print("$columns ")
                }
                print("Miasta.: ")
            }
        }
    }

    

}