package com.example.shoppinglistapp.di

import com.example.shoppingListRepository.RepositoryInterface
import com.example.shoppingListRepository.ShoppingListRepository
import com.example.shoppinglistapp.database.ShoppingListDao
import com.example.shoppinglistapp.model.EntityMapperImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Repository {
    @Singleton
    @Provides
    fun provideRepository(
        entityMapperImplementation: EntityMapperImplementation,
        shoppingListDao: ShoppingListDao
    ):RepositoryInterface{
        return ShoppingListRepository(entityMapperImplementation,shoppingListDao)
    }
}