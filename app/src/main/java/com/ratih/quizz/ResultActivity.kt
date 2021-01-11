package com.ratih.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        val setName = intent.getStringExtra(Constaints.USER_NAME)
        tv_name.text = setName

        val totalQuestion = intent.getIntExtra(Constaints.TOTAL_QUESTIONS,0)
        val correctAnswer = intent.getIntExtra(Constaints.CORRECT_ANSWER,0)

        tv_score.text = "Your Score is $correctAnswer out of $totalQuestion"

        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}