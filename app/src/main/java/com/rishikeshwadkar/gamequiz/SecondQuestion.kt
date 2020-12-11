package com.rishikeshwadkar.gamequiz

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_first_question.*
import kotlinx.android.synthetic.main.fragment_second_question.*
import kotlinx.android.synthetic.main.fragment_second_question.view.*

class SecondQuestion : Fragment() {

    //same as FragmentFirst

    private val args: SecondQuestionArgs by navArgs()
    private var i: Int = 0
    private var points: Int = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_second_question, container, false)
        i = args.i2
        points = args.points
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        secondtoggleButton1.isEnabled = true
        secondtoggleButton2.isEnabled = true
        secondtoggleButton3.isEnabled = true
        secondtoggleButton4.isEnabled = true

        secondQuestionTV.text = resources.getStringArray(R.array.Questions)[i]
        view.points.text = points.toString()
        if(i==1){
            secondtoggleButton1.text = resources.getStringArray(R.array.ans1)[0]
            secondtoggleButton1.textOn = resources.getStringArray(R.array.ans1)[0]
            secondtoggleButton1.textOff = resources.getStringArray(R.array.ans1)[0]

            secondtoggleButton2.text = resources.getStringArray(R.array.ans1)[1]
            secondtoggleButton2.textOn = resources.getStringArray(R.array.ans1)[1]
            secondtoggleButton2.textOff = resources.getStringArray(R.array.ans1)[1]

            secondtoggleButton3.text = resources.getStringArray(R.array.ans1)[2]
            secondtoggleButton3.textOn = resources.getStringArray(R.array.ans1)[2]
            secondtoggleButton3.textOff = resources.getStringArray(R.array.ans1)[2]

            secondtoggleButton4.text = resources.getStringArray(R.array.ans1)[3]
            secondtoggleButton4.textOn = resources.getStringArray(R.array.ans1)[3]
            secondtoggleButton4.textOff = resources.getStringArray(R.array.ans1)[3]
        }
        else if(i==3){
            secondtoggleButton1.text = resources.getStringArray(R.array.ans3)[0]
            secondtoggleButton1.textOn = resources.getStringArray(R.array.ans3)[0]
            secondtoggleButton1.textOff = resources.getStringArray(R.array.ans3)[0]

            secondtoggleButton2.text = resources.getStringArray(R.array.ans3)[1]
            secondtoggleButton2.textOn = resources.getStringArray(R.array.ans3)[1]
            secondtoggleButton2.textOff = resources.getStringArray(R.array.ans3)[1]

            secondtoggleButton3.text = resources.getStringArray(R.array.ans3)[2]
            secondtoggleButton3.textOn = resources.getStringArray(R.array.ans3)[2]
            secondtoggleButton3.textOff = resources.getStringArray(R.array.ans3)[2]

            secondtoggleButton4.text = resources.getStringArray(R.array.ans3)[3]
            secondtoggleButton4.textOn = resources.getStringArray(R.array.ans3)[3]
            secondtoggleButton4.textOff = resources.getStringArray(R.array.ans3)[3]
        }

        secondtoggleButton1.setOnClickListener {
            ansChecker(i,1)
            Handler().postDelayed({
                i++
                val action = SecondQuestionDirections.actionSecondQuestionToFirstQuestion(points,i)
                Navigation.findNavController(view).navigate(action)
            },1000)

            secondtoggleButton1.isEnabled = false
            secondtoggleButton2.isEnabled = false
            secondtoggleButton3.isEnabled = false
            secondtoggleButton4.isEnabled = false
        }

        secondtoggleButton2.setOnClickListener {
            ansChecker(i,2)

            Handler().postDelayed({
                i++
                val action = SecondQuestionDirections.actionSecondQuestionToFirstQuestion(points,i)
                Navigation.findNavController(view).navigate(action)
            },1000)

            secondtoggleButton1.isEnabled = false
            secondtoggleButton2.isEnabled = false
            secondtoggleButton3.isEnabled = false
            secondtoggleButton4.isEnabled = false
        }

        secondtoggleButton3.setOnClickListener {
            ansChecker(i,3)

            Handler().postDelayed({
                i++
                val action = SecondQuestionDirections.actionSecondQuestionToFirstQuestion(points,i)
                Navigation.findNavController(view).navigate(action)
            },1000)

            secondtoggleButton1.isEnabled = false
            secondtoggleButton2.isEnabled = false
            secondtoggleButton3.isEnabled = false
            secondtoggleButton4.isEnabled = false
        }

        secondtoggleButton4.setOnClickListener {
            ansChecker(i,4)

            Handler().postDelayed({
                i++
                val action = SecondQuestionDirections.actionSecondQuestionToFirstQuestion(points,i)
                Navigation.findNavController(view).navigate(action)
            },1000)

            secondtoggleButton1.isEnabled = false
            secondtoggleButton2.isEnabled = false
            secondtoggleButton3.isEnabled = false
            secondtoggleButton4.isEnabled = false
        }

    }
//------------------------------Functions--------------------------------------

    fun ansChecker(i:Int,caller:Int){
        if(i==0){
            if(caller==1){
                ansSetter(caller)
            }
            else{
                ansWrong(caller)
            }
        }
        else if(i==1){
            if(caller==4){
                points += 20
                ansSetter(caller)
            }
            else{
                points -= 5
                ansGray()
                ansSetter(4)
                ansWrong(caller)
            }
        }
        else if(i==3){
            if(caller==3){
                points += 20
                ansSetter(caller)
            }
            else{
                points -= 5
                ansGray()
                ansSetter(3)
                ansWrong(caller)
            }
        }
    }

    fun ansGray(){
        secondtoggleButton1.setBackgroundResource(R.drawable.graybtn)
        secondtoggleButton2.setBackgroundResource(R.drawable.graybtn)
        secondtoggleButton3.setBackgroundResource(R.drawable.graybtn)
        secondtoggleButton4.setBackgroundResource(R.drawable.graybtn)
    }

    private fun ansSetter(ans: Int){
        if(ans==1){
            ansGray()
            secondtoggleButton1.setBackgroundResource(R.drawable.greenbtn)
        }
        else if(ans==2){
            ansGray()
            secondtoggleButton2.setBackgroundResource(R.drawable.greenbtn)
        }
        else if(ans==3){
            ansGray()
            secondtoggleButton3.setBackgroundResource(R.drawable.greenbtn)
        }
        else if(ans==4){
            ansGray()
            secondtoggleButton4.setBackgroundResource(R.drawable.greenbtn)
        }
    }

    fun ansWrong(ans: Int){
        if(ans==1){

            secondtoggleButton1.setBackgroundResource(R.drawable.redbtn)
        }
        else if(ans==2){

            secondtoggleButton2.setBackgroundResource(R.drawable.redbtn)
        }
        else if(ans==3){

            secondtoggleButton3.setBackgroundResource(R.drawable.redbtn)
        }
        else if(ans==4){

            secondtoggleButton4.setBackgroundResource(R.drawable.redbtn)
        }
    }
}