package com.example.cocktailapptest.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cocktailapptest.R
import com.example.cocktailapptest.model.remote.response.Drink

class CategoryAdapter(
    private val context: Context,
    private val onItemClick: (Drink) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var list = listOf<Drink>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_cocktal_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvCocktailCategory = itemView.findViewById<TextView>(R.id.tvCategoryName)

        fun bind(categoryOfDrink: Drink) {
            tvCocktailCategory.text = categoryOfDrink.category

            itemView.setOnClickListener {
                onItemClick.invoke(categoryOfDrink)
            }
        }

    }
}