package com.rishikeshwadkar.gamequiz

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_first_question.*


class FirstQuestion : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toggleButton1.isEnabled = true
        toggleButton2.isEnabled = true
        toggleButton3.isEnabled = true
        toggleButton4.isEnabled = true

        val i = 0
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
        else if(i==1){
            toggleButton1.text = resources.getStringArray(R.array.ans1)[0]
            toggleButton1.textOn = resources.getStringArray(R.array.ans1)[0]
            toggleButton1.textOff = resources.getStringArray(R.array.ans1)[0]

            toggleButton2.text = resources.getStringArray(R.array.ans1)[1]
            toggleButton2.textOn = resources.getStringArray(R.array.ans1)[1]
            toggleButton2.textOff = resources.getStringArray(R.array.ans1)[1]

            toggleButton3.text = resources.getStringArray(R.array.ans1)[2]
            toggleButton3.textOn = resources.getStringArray(R.array.ans1)[2]
            toggleButton3.textOff = resources.getStringArray(R.array.ans1)[2]

            toggleButton4.text = resources.getStringArray(R.array.ans1)[3]
            toggleButton4.textOn = resources.getStringArray(R.array.ans1)[3]
            toggleButton4.textOff = resources.getStringArray(R.array.ans1)[3]
        }

        toggleButton1.setOnClickListener {
            ansChecker(i,1)
            Handler().postDelayed({
                  Navigation.findNavController(view).navigate(R.id.action_firstQuestion_to_secondQuestion)
            },2000)
            toggleButton1.isEnabled = false
            toggleButton2.isEnabled = false
            toggleButton3.isEnabled = false
            toggleButton4.isEnabled = false
        }
        toggleButton2.setOnClickListener {
            ansChecker(i,2)
            toggleButton1.isEnabled = false
            toggleButton2.isEnabled = false
            toggleButton3.isEnabled = false
            toggleButton4.isEnabled = false
        }
        toggleButton3.setOnClickListener {
            ansChecker(i,3)
            toggleButton1.isEnabled = false
            toggleButton2.isEnabled = false
            toggleButton3.isEnabled = false
            toggleButton4.isEnabled = false
        }
        toggleButton4.setOnClickListener {
            ansChecker(i,4)
            toggleButton1.isEnabled = false
            toggleButton2.isEnabled = false
            toggleButton3.isEnabled = false
            toggleButton4.isEnabled = false
        }
    }



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
                ansSetter(caller)
            }
            else{
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
            ansGray()
            toggleButton1.setBackgroundResource(R.drawable.redbtn)
        }
        else if(ans==2){
            ansGray()
            toggleButton2.setBackgroundResource(R.drawable.redbtn)
        }
        else if(ans==3){
            ansGray()
            toggleButton3.setBackgroundResource(R.drawable.redbtn)
        }
        else if(ans==4){
            ansGray()
            toggleButton4.setBackgroundResource(R.drawable.redbtn)
        }
    }

}