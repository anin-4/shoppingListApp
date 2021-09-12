package com.example.shoppingListRepository

import com.example.shoppinglistapp.database.ShoppingListDao
import com.example.shoppinglistapp.model.EntityMapperImplementation
import com.example.shoppinglistapp.model.ShoppingListDomain
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class ShoppingListRepository @Inject constructor(
    private val entityMapperImplementation: EntityMapperImplementation,
    private val shoppingListDao:ShoppingListDao
):RepositoryInterface {
    override suspend fun getListOfItems(): List<ShoppingListDomain> {
        return entityMapperImplementation.entityToDomainList(shoppingListDao.getList())
        }

    override suspend fun getItem(): ShoppingListDomain {
        TODO("Not yet implemented")
    }

    override suspend fun pushItem(item: ShoppingListDomain) {
             shoppingListDao.insert(entityMapperImplementation.DomainToEntity(item))
    }

    override suspend fun deleteItem(item: ShoppingListDomain) {
        shoppingListDao.delete(entityMapperImplementation.DomainToEntity(item))
    }

    override suspend fun updateList(id: Int, quantity: Int) {
        shoppingListDao.updateList(id,quantity)
    }


}