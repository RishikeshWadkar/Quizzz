package com.rishikeshwadkar.gamequiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_game_over.*
import kotlinx.android.synthetic.main.fragment_game_over.view.*

class GameOver : Fragment() {

    private val args: GameOverArgs by navArgs()
    private var points: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_game_over, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        points = args.gameOverpoints
        view.gameOverPointsTV.text = points.toString()

        finishbtn.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_gameOver_to_startPlaying2)
        }
    }

}