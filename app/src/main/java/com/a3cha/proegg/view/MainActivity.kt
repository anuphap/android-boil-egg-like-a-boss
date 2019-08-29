package com.a3cha.proegg.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.a3cha.proegg.R
import com.a3cha.proegg.data.RecipeRepository
import com.a3cha.proegg.data.local.LocalDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModelFactory = MainViewModelFactory(RecipeRepository.getInstance(LocalDatabase.getInstance(this)))
        mainViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        mainViewModel.recipes.observe(this, Observer { recipes ->
            recipes.forEach {
                Log.d(tag, it.name)
            }
        })
    }

    companion object {
        const val tag = "MainActivity"
    }
}
