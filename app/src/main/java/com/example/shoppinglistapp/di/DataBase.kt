package com.example.shoppinglistapp.di

import android.content.Context
import androidx.room.Room
import com.ShoppingListApplication
import com.example.shoppinglistapp.database.ShoppingListDatabase
import com.example.shoppinglistapp.model.EntityMapper
import com.example.shoppinglistapp.model.EntityMapperImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DataBase {

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context):ShoppingListDatabase{
            return  Room.databaseBuilder(
                    context,
                    ShoppingListDatabase::class.java,
                    "shopping_list"
                ).build()

            }
    @Singleton
    @Provides
    fun provideString():String{
        return "This is a silly string"
    }

    @Singleton
    @Provides
    fun provideDao(shoppingListDatabase: ShoppingListDatabase)=shoppingListDatabase.shoppingListDao()

    @Singleton
    @Provides
    fun provideEntityMapper(): EntityMapperImplementation {
        return EntityMapperImplementation()
    }
}