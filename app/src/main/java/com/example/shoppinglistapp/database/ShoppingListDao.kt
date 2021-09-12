package com.example.shoppinglistapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglistapp.model.ShoppingListEntity


@Dao
interface ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(shoppingItem:ShoppingListEntity)

    @Delete
    suspend fun delete(shoppingItem: ShoppingListEntity)

    @Query("select * from shopping_list")
    suspend fun getList():List<ShoppingListEntity>

    @Query("update shopping_list set item_count =:quantity where id=:id ")
    suspend fun updateList(id:Int,quantity:Int)
}