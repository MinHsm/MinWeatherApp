package com.min.minweatherapp.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.min.minweatherapp.R
import com.min.minweatherapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chipProfile.setItemSelected(R.id.profile, true)

//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )

        binding.chipProfile.setOnItemSelectedListener { id ->
            when (id) {
                R.id.home -> {
                    startActivity(Intent(this@ProfileActivity, MainActivity::class.java))
                }

                R.id.profile -> {
                    startActivity(Intent(this@ProfileActivity, ProfileActivity::class.java))
                }

                R.id.bookmark -> {
                    startActivity(Intent(this@ProfileActivity, BookMarkActivity::class.java))
                }
            }
        }
    }
}