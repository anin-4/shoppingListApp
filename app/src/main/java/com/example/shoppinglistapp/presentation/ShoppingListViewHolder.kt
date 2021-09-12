package com.example.shoppinglistapp.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.databinding.ShoppingListItemBinding
import com.example.shoppinglistapp.model.ShoppingListDomain

sealed class ShoppingListViewHolder(binding:ShoppingListItemBinding):RecyclerView.ViewHolder(binding.root) {

    var itemClickListener:((view: View, item:ShoppingListDomain,position:Int)->Unit)?=null

    class ShoppingItemHolder(private val binding: ShoppingListItemBinding):ShoppingListViewHolder(binding){
        fun bind(item:ShoppingListDomain){
            binding.shoppingItemTextView.text=item.Item.toString()
            binding.itemCountTextView.text=item.quantity.toString()
            binding.buttonDelete.setOnClickListener {
                itemClickListener?.invoke(it,item,adapterPosition)
            }
            binding.buttonPlus.setOnClickListener {
                itemClickListener?.invoke(it,item,adapterPosition)
            }
            binding.buttonMinus.setOnClickListener {
                itemClickListener?.invoke(it,item,adapterPosition)
            }
        }
    }

}