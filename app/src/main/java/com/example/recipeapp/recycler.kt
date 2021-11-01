package com.example.recipeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class recycler(val newRecipe:ArrayList<String>): RecyclerView.Adapter<recycler.ItemHolder>() {

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {

        return ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val userinput = newRecipe[position]
        holder.itemView.apply {

            tvRecycler.text = userinput
        }
    }

    override fun getItemCount() = newRecipe.size


}