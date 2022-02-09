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
import com.example.cocktailapptest.model.remote.response.CocktailByCategory


class CocktailListAdapter(
    private val context: Context,
    private val onItemClick: (CocktailByCategory) -> Unit
) : RecyclerView.Adapter<CocktailListAdapter.CocktailViewHolder>() {


    var list = listOf<CocktailByCategory>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CocktailViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_cocktail,
            parent,
            false
        )
        return CocktailViewHolder(view)
    }

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size


    inner class CocktailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCocktailName: TextView = itemView.findViewById<TextView>(R.id.tvCocktailName)
        private val ivCocktail: ImageView = itemView.findViewById<ImageView>(R.id.ivCocktail)

        fun bind(cocktail: CocktailByCategory) {
            Glide.with(context).load(cocktail.strDrinkThumb).into(ivCocktail)
            tvCocktailName.text = cocktail.strDrink

            itemView.setOnClickListener {
                onItemClick.invoke(cocktail)
            }
        }
    }
}