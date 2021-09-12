package com.example.shoppinglistapp.presentation

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.model.ShoppingListDomain

class ShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener):AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_box)
        val addButton=findViewById<Button>(R.id.button)
        val item1=findViewById<EditText>(R.id.editTextTextPersonName)
        val item2=findViewById<EditText>(R.id.editTextTextPersonName2)
        addButton?.setOnClickListener {
             val name=item1?.text.toString()
            val quantity=Integer.parseInt(item2?.text.toString())
            val item=ShoppingListDomain(Item=name,quantity = quantity)

            addDialogListener.onAddButtonListener(item)
            dismiss()

        }

    }

}