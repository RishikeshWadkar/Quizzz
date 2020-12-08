package com.rishikeshwadkar.gamequiz

import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_first_question.*
import kotlinx.android.synthetic.main.fragment_first_question.view.*


class FirstQuestion : Fragment() {

    private val args: SecondQuestionArgs by navArgs()
    private var points: Int = 10
    private var i = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first_question, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        i = args.i2
        points = args.points

        toggleButton1.isEnabled = true
        toggleButton2.isEnabled = true
        toggleButton3.isEnabled = true
        toggleButton4.isEnabled = true

        points = args.points
        view.points.text = points.toString()

        questionTV.text = resources.getStringArray(R.array.Questions)[i]

        if(i==0){
            toggleButton1.text = resources.getStringArray(R.array.ans0)[0]
            toggleButton1.textOn = resources.getStringArray(R.array.ans0)[0]
            toggleButton1.textOff = resources.getStringArray(R.array.ans0)[0]

            toggleButton2.text = resources.getStringArray(R.array.ans0)[1]
            toggleButton2.textOn = resources.getStringArray(R.array.ans0)[1]
            toggleButton2.textOff = resources.getStringArray(R.array.ans0)[1]

            toggleButton3.text = resources.getStringArray(R.array.ans0)[2]
            toggleButton3.textOn = resources.getStringArray(R.array.ans0)[2]
            toggleButton3.textOff = resources.getStringArray(R.array.ans0)[2]

            toggleButton4.text = resources.getStringArray(R.array.ans0)[3]
            toggleButton4.textOn = resources.getStringArray(R.array.ans0)[3]
            toggleButton4.textOff = resources.getStringArray(R.array.ans0)[3]

        }
        else if(i==2){
            toggleButton1.text = resources.getStringArray(R.array.ans2)[0]
            toggleButton1.textOn = resources.getStringArray(R.array.ans2)[0]
            toggleButton1.textOff = resources.getStringArray(R.array.ans2)[0]

            toggleButton2.text = resources.getStringArray(R.array.ans2)[1]
            toggleButton2.textOn = resources.getStringArray(R.array.ans2)[1]
            toggleButton2.textOff = resources.getStringArray(R.array.ans2)[1]

            toggleButton3.text = resources.getStringArray(R.array.ans2)[2]
            toggleButton3.textOn = resources.getStringArray(R.array.ans2)[2]
            toggleButton3.textOff = resources.getStringArray(R.array.ans2)[2]

            toggleButton4.text = resources.getStringArray(R.array.ans2)[3]
            toggleButton4.textOn = resources.getStringArray(R.array.ans2)[3]
            toggleButton4.textOff = resources.getStringArray(R.array.ans2)[3]
        }
        else if(i==4){
            toggleButton1.text = resources.getStringArray(R.array.ans4)[0]
            toggleButton1.textOn = resources.getStringArray(R.array.ans4)[0]
            toggleButton1.textOff = resources.getStringArray(R.array.ans4)[0]

            toggleButton2.text = resources.getStringArray(R.array.ans4)[1]
            toggleButton2.textOn = resources.getStringArray(R.array.ans4)[1]
            toggleButton2.textOff = resources.getStringArray(R.array.ans4)[1]

            toggleButton3.text = resources.getStringArray(R.array.ans4)[2]
            toggleButton3.textOn = resources.getStringArray(R.array.ans4)[2]
            toggleButton3.textOff = resources.getStringArray(R.array.ans4)[2]

            toggleButton4.text = resources.getStringArray(R.array.ans4)[3]
            toggleButton4.textOn = resources.getStringArray(R.array.ans4)[3]
            toggleButton4.textOff = resources.getStringArray(R.array.ans4)[3]
        }


        toggleButton1.setOnClickListener {
            ansChecker(i,1)
            if(i<4){
                Handler().postDelayed({
                    i++
                    val action = FirstQuestionDirections.actionFirstQuestionToSecondQuestion(i,points)
                    Navigation.findNavController(view).navigate(action)
                },1000)
            }
            else{
                Toast.makeText(activity, "${points}", Toast.LENGTH_SHORT).show()
                Handler().postDelayed({
                    val action = FirstQuestionDirections.actionFirstQuestionToGameOver(points)
                    Navigation.findNavController(view).navigate(action)
                },1000)
            }
            toggleButton1.isEnabled = false
            toggleButton2.isEnabled = false
            toggleButton3.isEnabled = false
            toggleButton4.isEnabled = false
        }

        toggleButton2.setOnClickListener {
            ansChecker(i,2)
            if(i<4){
                Handler().postDelayed({
                    i++
                    val action = FirstQuestionDirections.actionFirstQuestionToSecondQuestion(i,points)
                    Navigation.findNavController(view).navigate(action)
                },1000)
            }
            else{
                Handler().postDelayed({
                    val action = FirstQuestionDirections.actionFirstQuestionToGameOver(points)
                    Navigation.findNavController(view).navigate(action)
                },1000)
            }
            toggleButton1.isEnabled = false
            toggleButton2.isEnabled = false
            toggleButton3.isEnabled = false
            toggleButton4.isEnabled = false
        }

        toggleButton3.setOnClickListener {
            ansChecker(i,3)
            if(i<4){
                Handler().postDelayed({
                    i++
                    val action = FirstQuestionDirections.actionFirstQuestionToSecondQuestion(i,points)
                    Navigation.findNavController(view).navigate(action)
                },1000)
            }
            else{
                Handler().postDelayed({
                    val action = FirstQuestionDirections.actionFirstQuestionToGameOver(points)
                    Navigation.findNavController(view).navigate(action)
                },1000)
            }
            toggleButton1.isEnabled = false
            toggleButton2.isEnabled = false
            toggleButton3.isEnabled = false
            toggleButton4.isEnabled = false
        }

        toggleButton4.setOnClickListener {
            ansChecker(i,4)

            if(i<4){
                Handler().postDelayed({
                    i++
                    val action = FirstQuestionDirections.actionFirstQuestionToSecondQuestion(i,points)
                    Navigation.findNavController(view).navigate(action)
                },1000)
            }
            else{
                Handler().postDelayed({
                    val action = FirstQuestionDirections.actionFirstQuestionToGameOver(points)
                    Navigation.findNavController(view).navigate(action)
                },1000)
            }
            toggleButton1.isEnabled = false
            toggleButton2.isEnabled = false
            toggleButton3.isEnabled = false
            toggleButton4.isEnabled = false
        }
    }

//------------------------------Functions--------------------------------------




    fun ansChecker(i:Int,caller:Int){
        if(i==0){
            if(caller==1){
                points += 20
                ansSetter(caller)
            }
            else{
                points -= 5
                ansGray()
                ansSetter(1)
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
        else if(i==2){
            if(caller==2){
                points += 20
                ansSetter(caller)
            }
            else{
                points -= 5
                ansGray()
                ansSetter(2)
                ansWrong(caller)
            }
        }
        else if(i==4){
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
    }


    fun ansGray(){
        toggleButton1.setBackgroundResource(R.drawable.graybtn)
        toggleButton2.setBackgroundResource(R.drawable.graybtn)
        toggleButton3.setBackgroundResource(R.drawable.graybtn)
        toggleButton4.setBackgroundResource(R.drawable.graybtn)
    }

    private fun ansSetter(ans: Int){
        if(ans==1){
            ansGray()
            toggleButton1.setBackgroundResource(R.drawable.greenbtn)
        }
        else if(ans==2){
            ansGray()
            toggleButton2.setBackgroundResource(R.drawable.greenbtn)
        }
        else if(ans==3){
            ansGray()
            toggleButton3.setBackgroundResource(R.drawable.greenbtn)
        }
        else if(ans==4){
            ansGray()
            toggleButton4.setBackgroundResource(R.drawable.greenbtn)
        }
    }

    fun ansWrong(ans: Int){
        if(ans==1){

            toggleButton1.setBackgroundResource(R.drawable.redbtn)
        }
        else if(ans==2){

            toggleButton2.setBackgroundResource(R.drawable.redbtn)
        }
        else if(ans==3){

            toggleButton3.setBackgroundResource(R.drawable.redbtn)
        }
        else if(ans==4){

            toggleButton4.setBackgroundResource(R.drawable.redbtn)
        }
    }

}