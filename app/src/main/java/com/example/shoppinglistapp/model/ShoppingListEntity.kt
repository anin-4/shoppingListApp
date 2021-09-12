package com.example.shoppinglistapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shopping_list")
data class ShoppingListEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,

    @ColumnInfo(name="item_name")
    val item:String?,

    @ColumnInfo(name="item_count")
    val count:Int?
)
