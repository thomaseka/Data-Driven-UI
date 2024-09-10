package com.example.buttondaridatabase.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.buttondaridatabase.data.Product
import com.example.buttondaridatabase.data.RectParams
import com.example.buttondaridatabase.repository.ProductRepository
import com.example.buttondaridatabase.repository.RectParamsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {

    // Flow for observing products
    val allProducts: Flow<List<Product>> = repository.allProducts

    // Function to insert product
    fun insertProduct(product: Product) {
        viewModelScope.launch {
            try {
                repository.insert(product)
            } catch (e: Exception) {
                // Handle the error, e.g., log it or show a message to the user
                Log.e("ProductViewModel", "Error inserting product: ${e.message}")
            }
        }
    }
}

//error asynchronous
//    val allProducts: StateFlow<List<Product>> = repository.getAllProducts()
//        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
//
//    // Function to insert data into the Product table
//    fun insertProduct(menuId: String, categoryName: String) {
//        viewModelScope.launch {
//            try {
//                repository.insertProduct(menuId, categoryName)
//            } catch (e: Exception) {
//                // Handle the error here
//                Log.e("ProductViewModel", "Error inserting product: ${e.message}")
//            }
//        }
//    }


class ProductViewModelFactory(private val repository: ProductRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
