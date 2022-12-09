package com.nkodem.a23_11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.jgrapht.DirectedGraph
import org.jgrapht.Graph



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rarity = resources.getStringArray(R.array.dystans)
        val randomRarity = rarity.random()
        val countRarity = rarity.count()
        val zmien = findViewById(R.id.zmien) as Button
        val dystans = findViewById(R.id.dystans) as TextView

        zmien.setOnClickListener {
            //val intent = Intent(this, dystans::class.java)
            //startActivity(intent)
            dystans.setText(randomRarity)
        }

        val test = findViewById(R.id.test) as Button
        val testowy = findViewById(R.id.testowy) as TextView

        test.setOnClickListener {
            testowy.setText(countRarity)
        }

        /*fun main(ards: Array<String>){
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
        }*/
        data class Edge(val source: String, val target: String, val duration: Int)
        fun Interable<Edge>.duration() = sumBy {it.duration}
        fun Interable<Edge>.visited() = map {it.source} + last().target
        operator fun <V> Graph <V, *>.plusAssign(vertex:V){addVertex(vertex)}
        operator fun Graph<String, Edge>.plusAssign(edge:Edge){addEdge(edge.source, edge.target, edge)}
        fun main(args: Array<String>) {
            val graph = SimpleDirectedGraph<String, Edge>(Edge::class.java)
            input.lines().forEach{ line
                val (route, duration) = line.split(" = ")
                val  (source, target) = route.split(" to ")

                graph += source
                graph += target
                graph += Edge(source, target, duration.toInt())
                graph += Edge(target, source, duration.toInt())

            }
            graph.findTravellingsalesmanRoute()?.let{
                println("Visited ${route.visited()} in ${route.duration()}")
            }
        }
        fun DirectedGraph<String, Edge>.findTravellingsalesmanRoute(route:List<Edge>? = null): List<Edge>?{
            val routes = if (route == nul){
                edgeSet().map { findTravellingsalesmanRoute(listOf(it))}
            }else if(route.visited().toSet() == vertexSet()){
                listOf(route)
            }else{
                outgoingEdgesOf(route.last().target)
                    .filterNO { route.visited().constains(it.target)}
                    .map { findTravellingsalesmanRoute(route + it)}
            }
            return routes.filterNotNull().minBy {it.duration()}
        }
    }

    

}