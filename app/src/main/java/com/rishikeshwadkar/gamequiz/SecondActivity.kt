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

    //lateinit var toggle: ActionBarDrawerToggle
    lateinit var navController: NavController
    private val startPlaying = StartPlaying()

    private var currentFragment: Fragment = startPlaying
    val fragmentManager: FragmentManager = supportFragmentManager
    val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val name = intent.getStringExtra("name")
        val temp = intent.getStringExtra("temp")

        navController = Navigation.findNavController(this,R.id.navHost)
        NavigationUI.setupWithNavController(navigationView,navController)
       // NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navigationView: NavigationView = navigationView
        val headerView: View = navigationView.getHeaderView(0)

        headerView.nav_header_tv.text = name
        if(temp == "1"){
            headerView.nav_header_image.setImageResource(R.drawable.man)
        }
        else if(temp == "2"){
            headerView.nav_header_image.setImageResource(R.drawable.woman)
        }
        else{
            headerView.nav_header_image.setImageResource(R.drawable.reaper)
        }

        val drawer: DrawerLayout = drawerLayout
        navMenuBtn.setOnClickListener {
            drawer.openDrawer(GravityCompat.START)
        }

//        navigationView.setNavigationItemSelectedListener {
//            when(it.itemId){
//                R.id.miAbout -> {loadFragment(aboutUs)
//                    currentFragment = aboutUs
//                }
//            }
//            true
//        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
                navController,
                drawerLayout
        )
    }

    fun loadFragment(fragment: Fragment){
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.navHost, fragment).commit()
        fragmentTransaction.addToBackStack(null)
    }

    private fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.navHost, fragment)
            commit()
        }
    }

    override fun onBackPressed() {
        val drawer: DrawerLayout = drawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START)
        }
//        else if(currentFragment == aboutUs || currentFragment == FirstQuestion() || currentFragment == SecondQuestion()
//            || currentFragment == GameOver()){
//            currentFragment = startPlaying
//        }
        else{
            super.onBackPressed()
        }
    }

}