package com.example.shoppinglistapp.presentation

import com.example.shoppinglistapp.model.ShoppingListDomain

interface AddDialogListener {

    fun onAddButtonListener(item:ShoppingListDomain)

}