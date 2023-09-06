package com.example.counterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val guess1 = findViewById<TextView>(R.id.Answer1)
    val guess1Check =  findViewById<TextView>(R.id.Answer1Check)
    val guess2 = findViewById<TextView>(R.id.Answer2)
    val guess2Check = findViewById<TextView>(R.id.Answer2Check)
    val guess3 = findViewById<TextView>(R.id.Answer3)
    val guess3Check = findViewById<TextView>(R.id.Answer3Check)
    val correctWordView = findViewById<TextView>(R.id.CorrectAnswer)


    val buttonVal = findViewById<Button>(R.id.SubmitButton)
    val wordObj =  FourLetterWordList
    val answer = wordObj.getRandomFourLetterWord()
    var attempts = 0
    println("Welcome to Wordle! Try to guess the secret word.")

    buttonVal.setOnClickListener{
        val guess = findViewById<EditText>(R.id.EditText)
        val check = checkGuess(guess.toString().uppercase(), answer)
        val maxAttempts = 3
        attempts ++


        if (guess.text.toString() == answer) {
            println("Congratulations! You guessed the secret word. ")
            buttonVal.isEnabled = false
            } else if (attempts == 3) {
                correctWordView.text = answer
                correctWordView.visibility = View.VISIBLE
        }

        if (attempts == 1) {
            guess1.text = check.toString().uppercase()
            guess1Check.text = check
        } else if(attempts == 2) {
                guess2.text = check.toString().uppercase()
                guess2Check.text = check
        }
        else if (attempts == 3) {
                guess3.text = check.toString().uppercase()
                guess3Check.text = check
        }
        }
    }

    private fun checkGuess(guess: String, wordToGuess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }




}