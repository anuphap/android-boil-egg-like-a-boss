package com.a3cha.proegg.data

import androidx.lifecycle.LiveData
import com.a3cha.proegg.data.local.LocalDatabase
import com.a3cha.proegg.data.local.model.Recipe

class RecipeRepository(private val localDatabase: LocalDatabase) {

    companion object {
        @Volatile
        private var INSTANCE: RecipeRepository? = null

        fun getInstance(localDatabase: LocalDatabase): RecipeRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: RecipeRepository(localDatabase).also { INSTANCE = it }
            }
    }

    val recipes: LiveData<List<Recipe>>
        get() = localDatabase.dataDao().getRecipes()
}