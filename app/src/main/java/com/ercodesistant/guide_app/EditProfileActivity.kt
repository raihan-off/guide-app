package com.ercodesistant.guide_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_edit_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Customize the activity as needed
    }
}