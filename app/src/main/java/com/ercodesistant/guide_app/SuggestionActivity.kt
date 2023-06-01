package com.ercodesistant.guide_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SuggestionActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggestion)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Customize the activity as needed
    }
}