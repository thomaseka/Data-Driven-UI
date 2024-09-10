package com.example.buttondaridatabase.repository

import android.util.Log
import com.example.buttondaridatabase.dao.ProductDao
import com.example.buttondaridatabase.data.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.withContext

class ProductRepository(private val productDao: ProductDao) {

//    fun getAllProducts(): Flow<List<Product>> {
//        return productDao.getAllList()
//            .catch { e ->
//                Log.e("ProductRepository", "Error fetching products: ${e.message}")
//                emit(emptyList())
//            }
//    }
//
//    fun insertProduct(menuId: String, categoryName: String) {
//        val product = Product(productId = menuId, name = categoryName)
//        productDao.insert(product)
//    }

    // Flow for observing data
    val allProducts = productDao.getAllList()

    // Function to insert product, running on IO dispatcher
    suspend fun insert(product: Product) {
        withContext(Dispatchers.IO) {
            productDao.insert(product)
        }
    }
}
