package com.example.buttondaridatabase.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0, // Allow auto-generation
    @ColumnInfo(name = "product_id")
    val productId: String,
    val name: String,
    val qty: Int = 1
)
