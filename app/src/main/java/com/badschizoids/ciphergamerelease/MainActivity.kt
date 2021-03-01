package com.badschizoids.ciphergamerelease

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.badschizoids.ciphergamerelease.network.DataFireStore
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var navView: BottomNavigationView
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.nav_host_fragment)
        navView = findViewById(R.id.navView)
        val appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.mainActionFragment, R.id.chatFragment
                )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        DataFireStore().getAllMemes().addOnCompleteListener {
            if (it.isSuccessful){
                val list = it.result?.get("mem") as List<String>
                list.forEach {
                    Log.e("Test", it)
                }
            }
            else
                Log.e("Data", it.exception?.message.toString())
        }
    }


    override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()
}