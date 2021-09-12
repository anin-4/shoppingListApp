package com.example.shoppinglistapp.presentation

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingListRepository.RepositoryInterface
import com.example.shoppinglistapp.model.ShoppingListDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingListViewModel @Inject constructor(
    private val repository: RepositoryInterface
): ViewModel() {

    private var _shoppingItems= MutableLiveData<List<ShoppingListDomain>>()

    val shoppingItems:LiveData<List<ShoppingListDomain>>
    get()=_shoppingItems

    private var _isLoading=MutableLiveData<Boolean>()

    val isLoading:LiveData<Boolean>
    get()=_isLoading

    init{
        getItems()
    }

    fun getItems(){
        viewModelScope.launch {
            _isLoading.value=true
            val response=repository.getListOfItems()
            _shoppingItems.value=response
            _isLoading.value=false
        }
    }

    fun addItems(item:ShoppingListDomain){
        viewModelScope.launch {
            repository.pushItem(item)
            val response=repository.getListOfItems()
            _shoppingItems.value=response
        }
    }

   fun deleteItems(item: ShoppingListDomain){
        viewModelScope.launch {
            repository.deleteItem(item)
            val response=repository.getListOfItems()
            _shoppingItems.value=response
        }
    }

    private fun updateList(id:Int,newCount:Int){
        viewModelScope.launch {
            repository.updateList(id,newCount)
            val response=repository.getListOfItems()
            _shoppingItems.value=response
        }
    }

    fun increment(item:ShoppingListDomain){
        item.quantity = item.quantity?.plus(1)
        updateList(item.id!!,item.quantity!!)
    }

    fun decrement(item:ShoppingListDomain){
        if(item.quantity!! >0){
           item.quantity=item.quantity?.minus(1)
            updateList(item.id!!,item.quantity!!)
        }
    }


}