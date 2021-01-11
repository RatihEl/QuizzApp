package com.ratih.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn_star.setOnClickListener{

            val inputName = et_name.text.toString().trim()

            if (inputName.isEmpty()){
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_SHORT).show()
            } else{
                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constaints.USER_NAME, et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }

}