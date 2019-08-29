package com.a3cha.proegg.view.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.a3cha.proegg.R
import com.a3cha.proegg.data.RecipeRepository
import com.a3cha.proegg.data.local.LocalDatabase
import com.a3cha.proegg.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityDetailBinding
    private lateinit var viewModelFactory: DetailViewModelFactory
    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val recipeId = intent.getStringExtra(EXTRA_RECIPE_ID)
        viewModelFactory = DetailViewModelFactory(recipeId,
                RecipeRepository.getInstance(LocalDatabase.getInstance(this)))
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailViewModel::class.java)

        setupObserve()
        setupOnClick()
    }

    private fun setupObserve() {
        viewModel.recipe.observe(this, Observer {
            dataBinding.recipe = it
        })

        viewModel.startedTimer.observe(this, Observer {
            if (it) dataBinding.timerView.startTimer() else dataBinding.timerView.resetTimer()
            dataBinding.timerStarted = it
        })
    }

    private fun setupOnClick() {
        dataBinding.onClickStartTimer = View.OnClickListener {
            viewModel.clickTimer()
        }
    }

    companion object {
        private const val tag = "DetailActivity"
        private const val EXTRA_RECIPE_ID = "extra_recipe_id"
        @JvmStatic
        fun startActivity(context: Context, recipeId: String) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_RECIPE_ID, recipeId)
            context.startActivity(intent)
        }
    }
}
