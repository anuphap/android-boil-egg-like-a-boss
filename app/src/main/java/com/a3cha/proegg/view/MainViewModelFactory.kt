package com.a3cha.proegg.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.a3cha.proegg.data.RecipeRepository

class MainViewModelFactory(private val repository: RecipeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }

}