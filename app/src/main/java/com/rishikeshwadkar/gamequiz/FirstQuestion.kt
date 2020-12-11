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

    private val args: SecondQuestionArgs by navArgs() // communicating between SecondFragment
    private var points: Int = 10 //Default user points
    private var i = 0 // it is used to take backup of current question

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first_question, container, false)
    }

//=======================================================< Main Code >=========================================================================

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        i = args.i2 // taking current question's index
        points = args.points // assigning current points

        //Enabling all toggle buttons
        toggleButton1.isEnabled = true
        toggleButton2.isEnabled = true
        toggleButton3.isEnabled = true
        toggleButton4.isEnabled = true

        view.points.text = points.toString() //assigning points to textView
        questionTV.text = resources.getStringArray(R.array.Questions)[i] // Question text based upon the index number i.e [i]

        //setting options text using index of question
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

//=========================================================< optionsClickListener >=======================================================================

        toggleButton1.setOnClickListener {
            ansChecker(i,1) // calling function with question index no. and caller button no.
            //there are 5 questions only so if index is 4 then to understand its last question this condition is being used
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

            // because of postDelay user cant click on another option while that 1 sec delay that's why buttons getting disabled
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

//======================================================< Functions >==========================================================================
    /*
    ansChecker do check the question by index and who is the caller
    and if question index and caller index (options) matched then
    declare ans is correct and color it green
    and increase the points
    else color it red and decrease points
    */
    fun ansChecker(i:Int,caller:Int){
        if(i==0){
            if(caller==1){
                points += 20
                ansSetter(caller) //to color it green
            }
            else{
                points -= 5
                ansGray()
                ansSetter(1) //to color correct ans green
                ansWrong(caller) // to color selected ans red
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

    //make color gray of all buttons
    fun ansGray(){
        toggleButton1.setBackgroundResource(R.drawable.graybtn)
        toggleButton2.setBackgroundResource(R.drawable.graybtn)
        toggleButton3.setBackgroundResource(R.drawable.graybtn)
        toggleButton4.setBackgroundResource(R.drawable.graybtn)
    }

    //make color green of caller
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

    //make color red of caller
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