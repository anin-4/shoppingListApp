package com.example.shoppinglistapp.model

interface EntityMapper<DomainModel,Entity> {

    fun EntityToDomain(entity:Entity):DomainModel

    fun DomainToEntity(domainModel: DomainModel):Entity
}