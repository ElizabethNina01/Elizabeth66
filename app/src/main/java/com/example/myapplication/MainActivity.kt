package com.example.myapplication

import Question
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadQuestion()
        setupView()
    }

    private fun loadQuestion() {
        questions= ArrayList()
        questions.add(Question("Es lima capital de peru?", true))
        questions.add(Question("Es europa un pais?", false))
        questions.add(Question("Es buenos aires capital de chile?", false))
        questions.add(Question("Es bogota capital de colombia", true))
        questions.add(Question("Es medellin capital de colombia?", false))
    }

    private fun setupView(){
        val btYes = findViewById<Button>(R.id.btSi)
        val btNo=findViewById<Button>(R.id.btNo)
        var textView= findViewById<TextView>(R.id.tvPregunta)
        val btNext=findViewById<Button>(R.id.btNext)
        textView.text=questions[pos].sentence
        btYes.setOnClickListener{
            if(questions[pos].answer==true){

                Toast.makeText(this,"correcto",Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this,"Correcto", Toast.LENGTH_LONG).show()
            }
        }

        btNo.setOnClickListener{
            Toast.makeText(this,"incorrecto",Toast.LENGTH_LONG).show()
        }
        btNext.setOnClickListener {
            pos++
            TextView.text=questions[pos].sentence
        }
    }
}