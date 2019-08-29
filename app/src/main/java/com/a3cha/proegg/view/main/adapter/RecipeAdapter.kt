package com.a3cha.proegg.view.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.a3cha.proegg.R
import com.a3cha.proegg.data.local.model.Recipe
import com.a3cha.proegg.databinding.ItemRecipeBinding

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    var items = listOf<Recipe>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = DataBindingUtil.inflate<ItemRecipeBinding>(inflater, R.layout.item_recipe,
                parent, false)
        return RecipeViewHolder(itemView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class RecipeViewHolder(private val dataBinding: ItemRecipeBinding) :
            RecyclerView.ViewHolder(dataBinding.root) {

        fun bind(recipe: Recipe) {
            dataBinding.item = recipe
            dataBinding.context = itemView.context
            dataBinding.executePendingBindings() // update view
        }
    }
}