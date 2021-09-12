package com.example.shoppingListRepository

import com.example.shoppinglistapp.model.ShoppingListDomain

interface RepositoryInterface {

    suspend fun getListOfItems():List<ShoppingListDomain>

    suspend fun getItem():ShoppingListDomain

    suspend fun pushItem(item:ShoppingListDomain)

    suspend fun deleteItem(item:ShoppingListDomain)

    suspend fun updateList(id:Int, quantity:Int)
}