package com.a3cha.proegg.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.a3cha.proegg.data.local.model.Recipe

@Dao
abstract class RecipeDao {
    @Insert
    abstract fun insertRecipes(recipe: List<Recipe>)

    @Query("SELECT * FROM recipe")
    abstract fun getRecipes(): LiveData<List<Recipe>>

    @Query("SELECT * FROM recipe WHERE id=:recipeId")
    abstract fun getRecipe(recipeId: String): LiveData<Recipe>
}