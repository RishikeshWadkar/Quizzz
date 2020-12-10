package com.rishikeshwadkar.gamequiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_start_playing.*

class StartPlaying : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_playing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startPlayingButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_startPlaying_to_firstQuestion)
        }

//        navigationView.setNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.miAbout -> Navigation.findNavController(view).navigate(R.id.action_startPlaying_to_aboutUs)
//            }
//            true
//        }
    }


}