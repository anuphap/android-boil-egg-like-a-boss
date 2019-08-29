package com.a3cha.proegg.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a3cha.proegg.data.RecipeRepository

class DetailViewModelFactory(private val recipeId: String, private val repository: RecipeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(recipeId, repository) as T
    }
}