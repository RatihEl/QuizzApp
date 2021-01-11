package com.ratih.quizz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_question.*
import kotlin.math.log

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswer: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUserName = intent.getStringExtra(Constaints.USER_NAME)

       mQuestionList = Constaints.getQuestion()

        setQuestion()
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_for.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }
    private fun setQuestion(){
    
        val question = mQuestionList!![mCurrentPosition-1]

        defaulOptionsView()

        if (mCurrentPosition == mQuestionList!!.size) {
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
        progressBar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" +  progressBar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_for.text = question.optionFour


    }
        private fun defaulOptionsView(){
            val options = ArrayList<TextView>()
            options.add(0, tv_option_one)
            options.add(1, tv_option_two)
            options.add(2, tv_option_three)
            options.add(3, tv_option_for)

            for (option in options){
                option.setTextColor(Color.parseColor("#7A8089"))
                option.typeface = Typeface.DEFAULT
                option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.shape
                )
            }

        }

    override fun onClick(v: View?) {

        when(v?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two,2)
            }

            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_for-> {
                selectedOptionView(tv_option_for,4)
            }

            R.id.btn_submit -> {
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }else ->{
                        val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constaints.USER_NAME, mUserName)
                        intent.putExtra(Constaints.CORRECT_ANSWER, mCorrectAnswer)
                        intent.putExtra(Constaints.TOTAL_QUESTIONS, mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                    }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.shape3)
                    }else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer, R.drawable.shapedua)
                    if(mCurrentPosition == mQuestionList!!.size){
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }

        }

    private fun answerView (answer:Int, drawableView: Int) {
        when(answer){
            1 ->{
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 ->{
            tv_option_two.background = ContextCompat.getDrawable(
                this, drawableView
            )
        }
            3 ->{
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 ->{
                tv_option_for.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum : Int){
        defaulOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.shape
        )
    }

}