package com.metehanbolat.orderappcompose.core.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.metehanbolat.orderappcompose.core.data.local.entities.OrderEntity
import com.metehanbolat.orderappcompose.core.data.local.entities.OrderProductEntity
import com.metehanbolat.orderappcompose.core.data.local.entities.OrderWithProductsDataObject

@Dao
interface OrderDao {

    @Transaction
    @Query("SELECT * FROM OrderEntity")
    suspend fun getOrderWithProducts(): List<OrderWithProductsDataObject>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(orderEntity: OrderEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderProductEntities(orderProductEntities: List<OrderProductEntity>)

}