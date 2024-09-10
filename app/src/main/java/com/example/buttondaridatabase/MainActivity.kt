package com.example.buttondaridatabase

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.buttondaridatabase.databases.AppDatabase
import com.example.buttondaridatabase.repository.ProductRepository
import com.example.buttondaridatabase.repository.RectParamsRepository
import com.example.buttondaridatabase.viewmodel.ProductViewModel
import com.example.buttondaridatabase.viewmodel.ProductViewModelFactory
import com.example.buttondaridatabase.viewmodel.RectParamsViewModel
import com.example.buttondaridatabase.viewmodel.RectParamsViewModelFactory
//import com.example.buttondaridatabase.repository.ProductRepository
//import com.example.buttondaridatabase.viewmodel.ProductViewModelFactory
//import com.example.buttondaridatabase.viewmodel.ProductViewModel

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            val appDatabase = AppDatabase.getDatabase(applicationContext)
//            // Initialize the repository
//            val repositoryLocation = RectParamsRepository(appDatabase.msButton())
//            // Create the ViewModel using the factory
//            val viewModelFactory = RectParamsViewModelFactory(repositoryLocation)
//            val viewModel: RectParamsViewModel by viewModels { viewModelFactory }
//
//            // Initialize ProductRepository and ViewModel
//            val productRepository = ProductRepository(appDatabase.productDao())
//            val productViewModelFactory = ProductViewModelFactory(productRepository)
//            val productViewModel: ProductViewModel by viewModels { productViewModelFactory }
//
//            //Pass the ViewModel to RectMasterScreen
//            RectMasterScreen(viewModel = viewModel, productViewModel = productViewModel)
//            ListOrderItem(productViewModel = productViewModel)
//        }
//    }
//}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appDatabase = AppDatabase.getDatabase(applicationContext)
            // Initialize the repository
            val repositoryLocation = RectParamsRepository(appDatabase.msButton())
            // Create the ViewModel using the factory
            val viewModelFactory = RectParamsViewModelFactory(repositoryLocation)
            val viewModel: RectParamsViewModel by viewModels { viewModelFactory }

            // Initialize ProductRepository and ViewModel
            val productRepository = ProductRepository(appDatabase.productDao())
            val productViewModelFactory = ProductViewModelFactory(productRepository)
            val productViewModel: ProductViewModel by viewModels { productViewModelFactory }
            
//            ListOrderItem(productViewModel = productViewModel)
            // Pass the ViewModel to RectMasterScreen
//            MainScreen(viewModel, productViewModel)
            RectMasterScreen(viewModel = viewModel, productViewModel = productViewModel)
            ListOrderItem(
                productViewModel = productViewModel,
                modifier = Modifier,
                topPadding = 35.dp, // Set the desired top padding
                startPadding = 450.dp // Set the desired start padding
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LayoutPreview() {

}