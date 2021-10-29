package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var resultTextView: TextView

    private var operand1: Double = 0.0
    var operand2: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(clickedView: View){
        if (clickedView is TextView){

            val number = clickedView.text.toString()
            val resultText: String = resultTextView.text.toString()

            resultTextView.text = resultText + number
        }

    }

    fun operatonClick(clickedOperationView: View){

        if(clickedOperationView is TextView){

            var result: String = resultTextView.text.toString()

            if (result.isNotEmpty()){
                this.operand1 = result.toDouble()
            }

            resultTextView.text = " "
            this.operation = clickedOperationView.text.toString()

        }

    }

    fun equalsClick(clickedEqualsView: View){

        var secOperandText: String = resultTextView.text.toString()

        if (secOperandText.isNotEmpty()){
            operand2 = secOperandText.toDouble()
        }

        when(this.operation){

            "+" -> resultTextView.text = (operand1 + operand2).toString()
            "-" -> resultTextView.text = (operand1 - operand2).toString()
            "*" -> resultTextView.text = (operand1 * operand2).toString()
            "/" -> resultTextView.text = (operand1 / operand2).toString()
            "^" -> resultTextView.text = (Math.pow(operand1,operand2)).toString()
            "sqrt" -> resultTextView.text = (Math.sqrt(operand1)).toString()

        }

    }

    fun eraserClick(clickedEraser: View){

        resultTextView.text = ""
        this.operand1 = 0.0
        this.operand2 = 0.0

    }


}

