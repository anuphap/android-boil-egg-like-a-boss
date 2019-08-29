package com.a3cha.proegg.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.a3cha.proegg.data.RecipeRepository
import com.a3cha.proegg.data.local.model.Recipe

class MainViewModel(private val repository: RecipeRepository) : ViewModel() {

    val recipes: LiveData<List<Recipe>>
        get() = repository.recipes
}