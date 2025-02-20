package com.min.minweatherapp.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.min.minweatherapp.R
import com.min.minweatherapp.databinding.ActivityBookMarkBinding

class BookMarkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookMarkBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookMarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chipBookmark.setItemSelected(R.id.bookmark, true)

//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )

        binding.chipBookmark.setOnItemSelectedListener { id ->
            when (id) {
                R.id.home -> {
                    startActivity(Intent(this@BookMarkActivity, MainActivity::class.java))
                }

                R.id.profile -> {
                    startActivity(Intent(this@BookMarkActivity, ProfileActivity::class.java))
                }

                R.id.bookmark -> {
                    startActivity(Intent(this@BookMarkActivity, BookMarkActivity::class.java))
                }
            }
        }
    }
}