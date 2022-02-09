package com.example.cocktailapptest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cocktailapptest.R
import com.example.cocktailapptest.databinding.ActivityCocktailsByCategoryBinding

import com.example.cocktailapptest.databinding.ActivityMainBinding
import com.example.cocktailapptest.view.MainActivity.Companion.COCKTAIL_CATEGORY
import com.example.cocktailapptest.view.MainActivity.Companion.COCKTAIL_ID
import com.example.cocktailapptest.view.adapters.CocktailListAdapter
import com.example.cocktailapptest.viewmodel.CocktailsViewModel
import com.example.cocktailapptest.viewmodel.factory.CocktailsViewModelFactory

class CocktailsActivity : AppCompatActivity() {

    private lateinit var cocktailsListAdapter: CocktailListAdapter
    private lateinit var binding: ActivityCocktailsByCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCocktailsByCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!intent.hasExtra(COCKTAIL_CATEGORY)) {
            finish()
            return
        }

        val category = intent.getStringExtra(COCKTAIL_CATEGORY)

        val viewModel: CocktailsViewModel by lazy {
            ViewModelProvider(
                this,
                CocktailsViewModelFactory(category.toString())
            )[CocktailsViewModel::class.java]
        }

        cocktailsListAdapter = CocktailListAdapter(this) { cocktailByCategory ->
            val intent = Intent(this, CocktailDetailsActivity::class.java)
            intent.putExtra(COCKTAIL_ID, cocktailByCategory.idDrink)
            startActivity(intent)
        }

        binding.rvCocktailsList.adapter = cocktailsListAdapter
        binding.rvCocktailsList.layoutManager = LinearLayoutManager(this)

        viewModel.getCocktailsByCategory.observe(this, Observer {
            cocktailsListAdapter.list = it
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
}