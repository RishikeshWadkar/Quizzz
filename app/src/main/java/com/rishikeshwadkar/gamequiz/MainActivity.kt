package com.rishikeshwadkar.gamequiz

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawable: Drawable = circleImageView.drawable
        var temp: Int = 1

        nextButton.setOnClickListener {
            var name = etEnterName.text.toString()
            if(name != ""){
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("temp",temp.toString())
                startActivity(intent)
            }
            else{
                Snackbar.make(constarintLayout,"Enter Your Name",Snackbar.LENGTH_SHORT).show()
            }
        }

        circleImageView.setOnClickListener {
            if(temp == 1){
                circleImageView.setImageResource(R.drawable.woman)
                temp = 2
            }
            else if(temp == 2){
                circleImageView.setImageResource(R.drawable.reaper)
                temp = 3
            }
            else{
                circleImageView.setImageResource(R.drawable.man)
                temp = 1
            }

        }
    }
}