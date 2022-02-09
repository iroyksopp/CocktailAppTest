package com.example.cocktailapptest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cocktailapptest.R
import com.example.cocktailapptest.databinding.ActivityMainBinding
import com.example.cocktailapptest.view.adapters.CategoryAdapter
import com.example.cocktailapptest.viewmodel.MainViewModel
import com.example.cocktailapptest.viewmodel.factory.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: MainViewModel by lazy {
            ViewModelProvider(
                this,
                MainViewModelFactory()
            )[MainViewModel::class.java]
        }

        categoryAdapter = CategoryAdapter(this) { drink ->
            val intent = Intent(this, CocktailsActivity::class.java)
            intent.putExtra(COCKTAIL_CATEGORY, drink.category)
            startActivity(intent)
        }

        binding.rvCategory.adapter = categoryAdapter
        binding.rvCategory.layoutManager = GridLayoutManager(this, 2)

        viewModel.getCocktailCategories.observe(this, Observer {
            categoryAdapter.list = it
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itemMain -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.itemFavourites -> {
                val intent = Intent(this, SavedCocktailsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    companion object {
        const val COCKTAIL_ID = "cocktail_id"
        const val COCKTAIL_CATEGORY = "cocktail_category"
    }
}