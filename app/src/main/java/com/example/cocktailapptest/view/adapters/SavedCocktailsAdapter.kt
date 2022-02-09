package com.example.cocktailapptest.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cocktailapptest.R
import com.example.cocktailapptest.model.remote.response.Cocktail


class SavedCocktailsAdapter(
    private val context: Context,
    private val onItemClick: (Cocktail) -> Unit
) : RecyclerView.Adapter<SavedCocktailsAdapter.SavedCocktailViewHolder>() {

    var list = listOf<Cocktail>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedCocktailViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_cocktail,
            parent,
            false
        )
        return SavedCocktailViewHolder(view)
    }

    override fun onBindViewHolder(holder: SavedCocktailViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class SavedCocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCocktailName: TextView = itemView.findViewById<TextView>(R.id.tvCocktailName)
        private val ivCocktail: ImageView = itemView.findViewById<ImageView>(R.id.ivCocktail)
        fun bind(cocktail: Cocktail) {
            Glide.with(context).load(cocktail.image).into(ivCocktail)
            tvCocktailName.text = cocktail.cocktailName

            itemView.setOnClickListener {
                onItemClick.invoke(cocktail)
            }
        }
    }
}