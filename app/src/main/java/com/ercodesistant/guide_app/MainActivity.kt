package com.ercodesistant.guide_app

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ercodesistant.guide_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_informasi, R.id.navigation_work, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_edit_profile -> {
                val intent = Intent(this, EditProfileActivity::class.java)
                startActivity(intent)
                return true
            }

            R.id.bantuan -> {
                val intent = Intent(this, HelpActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.suggestion -> {
                val intent = Intent(this, SuggestionActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.laporkan_masalah  -> {
                val intent = Intent(this, ReportActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menu_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            // Tambahkan option menu sesuai kebutuhan
            else -> return super.onOptionsItemSelected(item)
        }
    }
}