package com.example.shoppinglistapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglistapp.databinding.ShoppingListItemBinding
import com.example.shoppinglistapp.model.ShoppingListDomain

class ShoppingListAdapter:RecyclerView.Adapter<ShoppingListViewHolder>(){

    var items=listOf<ShoppingListDomain>()
        set(value){
            field=value
            notifyDataSetChanged()
        }
    var itemClickListener:((view: View, item:ShoppingListDomain, position:Int)->Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
        return ShoppingListViewHolder.ShoppingItemHolder(
            ShoppingListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
        holder.itemClickListener=itemClickListener
        when(holder){
            is ShoppingListViewHolder.ShoppingItemHolder -> holder.bind(items[position])
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

}