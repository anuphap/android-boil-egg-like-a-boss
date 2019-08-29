package com.a3cha.proegg.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.a3cha.proegg.R
import com.a3cha.proegg.data.RecipeRepository
import com.a3cha.proegg.data.local.LocalDatabase
import com.a3cha.proegg.databinding.ActivityMainBinding
import com.a3cha.proegg.view.main.adapter.RecipeAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel
    private lateinit var dataBinding: ActivityMainBinding

    private val recipeAdapter by lazy { RecipeAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainViewModelFactory(
            RecipeRepository.getInstance(LocalDatabase.getInstance(this))
        )
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        setupData()
    }

    private fun setupData() {
        // Set adapter to view
        dataBinding.recipeAdapter = recipeAdapter

        viewModel.recipes.observe(this, Observer { recipes ->
            recipeAdapter.items = recipes
        })
    }

    companion object {
        const val tag = "MainActivity"
    }
}
