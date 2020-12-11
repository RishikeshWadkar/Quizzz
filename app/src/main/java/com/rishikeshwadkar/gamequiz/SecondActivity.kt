package com.rishikeshwadkar.gamequiz

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.nav_header.*
import kotlinx.android.synthetic.main.nav_header.view.*

class SecondActivity : AppCompatActivity(){

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("name") // tacking name of the user from first activity
        val temp = intent.getStringExtra("temp") // tacking temp value to validate the profile photo

        navController = Navigation.findNavController(this,R.id.navHost) //takes fragment container and control it
        NavigationUI.setupWithNavController(navigationView,navController)
        //NavigationUI is for dependencies and it takes sidebar i.e NavigationView and navController

        supportActionBar?.setDisplayHomeAsUpEnabled(true) //idk the use

        val navigationView: NavigationView = navigationView // it takes reference of NavigationView
        val headerView: View = navigationView.getHeaderView(0) //it takes reference of headerView

        headerView.nav_header_tv.text = name
        //assigning the profile image
        when (temp) {
            "1" -> {
                headerView.nav_header_image.setImageResource(R.drawable.man)
            }
            "2" -> {
                headerView.nav_header_image.setImageResource(R.drawable.woman)
            }
            else -> {
                headerView.nav_header_image.setImageResource(R.drawable.reaper)
            }
        }

        val drawer: DrawerLayout = drawerLayout //it takes reference of DrawerLayout
        //to open drawer by custom button
        navMenuBtn.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }
    }

    //it close the navigation drawer when we click on any menu item
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
                navController,
                drawerLayout
        )
    }

    //on backPressed check if drawer is open if open then close drawer not activity
    override fun onBackPressed() {
        val drawer: DrawerLayout = drawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }
        else{
            super.onBackPressed()
        }
    }

}