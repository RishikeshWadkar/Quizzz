package com.rishikeshwadkar.gamequiz

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_about_us.*

class AboutUs : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_us, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //intent to start instagram app or open url in a browser
        instagramBtn.setOnClickListener {
            val uri: Uri = Uri.parse("https://www.instagram.com/rishikesh_9217/")
            val intent: Intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.instagram.android")
            try {
                startActivity(intent)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/rishikesh_9217/")))
            }
        }

        linkedinBtn.setOnClickListener {
            val uri: Uri = Uri.parse("https://www.linkedin.com/in/rishikesh-wadkar-0aa455191/")
            val intent: Intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.linkedin.android")
            try {
                startActivity(intent)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rishikesh-wadkar-0aa455191/")))
            }
        }

        twitterBtn.setOnClickListener {
            val uri: Uri = Uri.parse("https://twitter.com/WadkarRishikesh")
            val intent: Intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.twitter.android")
            try {
                startActivity(intent)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/WadkarRishikesh")))
            }
        }

        githubBtn.setOnClickListener {
            val uri: Uri = Uri.parse("https://github.com/RishikeshWadkar")
            val intent: Intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.github.android")
            try {
                startActivity(intent)
            }catch (e: ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/RishikeshWadkar")))
            }
        }
    }
}