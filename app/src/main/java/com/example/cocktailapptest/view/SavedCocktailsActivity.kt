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
import com.example.cocktailapptest.databinding.ActivitySavedCocktailsBinding
import com.example.cocktailapptest.view.MainActivity.Companion.COCKTAIL_ID
import com.example.cocktailapptest.view.adapters.SavedCocktailsAdapter
import com.example.cocktailapptest.viewmodel.MainViewModel
import com.example.cocktailapptest.viewmodel.SavedCocktailsViewModel
import com.example.cocktailapptest.viewmodel.factory.MainViewModelFactory

class SavedCocktailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySavedCocktailsBinding
    private lateinit var savedCocktailsAdapter: SavedCocktailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySavedCocktailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedCocktailsAdapter = SavedCocktailsAdapter(this) { cocktail ->
            val intent = Intent(this, CocktailDetailsActivity::class.java)
            intent.putExtra(COCKTAIL_ID, cocktail.idCocktail)
            startActivity(intent)
        }

        binding.rvSavedCockTails.adapter = savedCocktailsAdapter
        binding.rvSavedCockTails.layoutManager = LinearLayoutManager(this)

        val viewModel: SavedCocktailsViewModel by lazy {
            ViewModelProvider(
                this,
                MainViewModelFactory()
            )[SavedCocktailsViewModel::class.java]
        }

        viewModel.getSavedCocktails.observe(this, Observer {
            savedCocktailsAdapter.list = it
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