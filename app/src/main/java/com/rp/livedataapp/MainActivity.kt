package com.rp.livedataapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.age.observe(this) { age ->
            Toast.makeText(this, age.toString(), Toast.LENGTH_SHORT).show()
        }
        //changeDataInEveryXSecondsUntil(1,10)



        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.getNumbers(
                context = this@MainActivity
            )
        }
    }

    // change the age data in every x seconds from 0 to instances
    fun changeDataInEveryXSecondsUntil(seconds: Int, instances: Int) {
        lifecycleScope.launch {
            for (i in 0..instances) {
                viewModel.setAgeData(i)
                delay((seconds * 1000L).milliseconds)
            }
        }
    }

}