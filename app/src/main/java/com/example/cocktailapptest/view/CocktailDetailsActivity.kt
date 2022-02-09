package com.example.cocktailapptest.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.cocktailapptest.R
import com.example.cocktailapptest.databinding.ActivityCocktailDetailsBinding
import com.example.cocktailapptest.view.MainActivity.Companion.COCKTAIL_ID
import com.example.cocktailapptest.viewmodel.CocktailDetailsViewModel
import com.example.cocktailapptest.viewmodel.factory.CocktailDetailsViewModelFactory

class CocktailDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCocktailDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCocktailDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!intent.hasExtra(COCKTAIL_ID)) {
            finish()
            return
        }
        val id = intent.getStringExtra(COCKTAIL_ID)

        val viewModel: CocktailDetailsViewModel by lazy {
            ViewModelProvider(
                this,
                CocktailDetailsViewModelFactory(id.toString())
            )[CocktailDetailsViewModel::class.java]
        }


        viewModel.getCocktailById.observe(this, Observer {
           with(binding) {
               tvDetailsCocktailName.text = it.cocktailName
               tvInstruction.text = it.cocktailInstruction
               Glide.with(this@CocktailDetailsActivity).load(it.image).into(ivDetailCocktail)
           }
        })

        binding.ivAddFavourite.setOnClickListener {
                viewModel.saveCocktail()
        }
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