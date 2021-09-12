package com.example.shoppinglistapp.model



class EntityMapperImplementation:EntityMapper<ShoppingListDomain,ShoppingListEntity> {
    override fun EntityToDomain(entity: ShoppingListEntity): ShoppingListDomain {
        return ShoppingListDomain(
            id= entity.id,
            Item = entity.item,
            quantity = entity.count
        )
    }

    override fun DomainToEntity(domainModel: ShoppingListDomain): ShoppingListEntity {
        return ShoppingListEntity(
            id=domainModel.id,
            item = domainModel.Item,
            count = domainModel.quantity,
        )
    }

    fun entityToDomainList(listOfEntity: List<ShoppingListEntity>):List<ShoppingListDomain>{
        return listOfEntity.map{
            EntityToDomain(it)
        }
    }

}