package com.a3cha.proegg.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.a3cha.proegg.data.RecipeRepository
import com.a3cha.proegg.data.local.model.Recipe

class DetailViewModel(recipeId: String, repository: RecipeRepository) : ViewModel() {
    val recipe: LiveData<Recipe> = repository.getRecipe(recipeId)

    private val _startedTimer = MutableLiveData<Boolean>()
    val startedTimer: LiveData<Boolean>
        get() = _startedTimer

    init {
        _startedTimer.postValue(false)
    }

    fun clickTimer() {
        _startedTimer.value = !(_startedTimer.value as Boolean)
    }
}