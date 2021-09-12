package com.example.shoppinglistapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistapp.databinding.ActivityMainBinding
import com.example.shoppinglistapp.model.ShoppingListDomain
import com.example.shoppinglistapp.presentation.AddDialogListener
import com.example.shoppinglistapp.presentation.ShoppingItemDialog
import com.example.shoppinglistapp.presentation.ShoppingListAdapter
import com.example.shoppinglistapp.presentation.ShoppingListViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val viewModel:ShoppingListViewModel by viewModels()
    private var shoppingListAdapter:ShoppingListAdapter= ShoppingListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.shoppingListItem.apply {
            layoutManager=LinearLayoutManager(this@MainActivity)
            adapter=shoppingListAdapter
        }

        viewModel.shoppingItems.observe(this){
            shoppingListAdapter.items=it
        }

        shoppingListAdapter.itemClickListener={view, item, _ ->
            if(view.id==R.id.button_delete){
                viewModel.deleteItems(item)

            }
            else if(view.id==R.id.button_plus){
                viewModel.increment(item)
            }
            else if(view.id==R.id.button_minus){
                viewModel.decrement(item)
            }

        }

        binding.fab.setOnClickListener {
            ShoppingItemDialog(this,object:AddDialogListener{
                override fun onAddButtonListener(item: ShoppingListDomain) {
                    viewModel.addItems(item)
                }
            }).show()
        }

        viewModel.isLoading.observe(this){
            if(it){
                binding.progressBar.visibility=View.VISIBLE
            }
            else{
                binding.progressBar.visibility=View.INVISIBLE
            }
        }
    }


}