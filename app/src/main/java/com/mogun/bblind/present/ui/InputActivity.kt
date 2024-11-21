package com.mogun.bblind.present.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mogun.bblind.databinding.ActivityInputBinding


class InputActivity: AppCompatActivity() {

    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater).apply {
            setContentView(root)
            view = this@InputActivity
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}