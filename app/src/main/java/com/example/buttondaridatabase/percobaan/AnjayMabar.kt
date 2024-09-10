//package com.example.buttondaridatabase.percobaan
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import com.example.buttondaridatabase.data.Product
//
//
////@Composable
////fun ProductListScreen() {
////    val productList = listOf(
////        Product(1, "Smartphone", 599.99),
////        Product(2, "Laptop", 1299.99),
////        Product(3, "A", 599.99),
////        Product(4, "B", 1299.99),
////        Product(5, "C", 599.99),
////        Product(6, "D", 1299.99),
////        Product(7, "E", 599.99)
////    )
////
////    // Pastikan selalu ada 10 items dalam list
////    val fixedSize = 10
////    val displayProductList = if (productList.size > fixedSize) {
////        productList.subList(0, fixedSize)  // Ambil hanya fixedSize pertama dari productList
////    } else {
////        productList.toMutableList().apply {
////            while (this.size < fixedSize) {
////                this.add(Product(null, null, null))  // Tambahkan item kosong jika kurang dari fixedSize
////            }
////        }
////    }
////
////    LazyColumn {
////        items(displayProductList) { product ->
////            if (product.id != null) {
////                ProductItem(product){ selectedProduct ->
////                    println("Click on: ${selectedProduct.name} that Cost: ${selectedProduct.price}")
////
////                }
////            } else {
////                EmptyProductItem()  // Tampilkan kotak kosong
////            }
////        }
////    }
////}
//
//@Composable
//fun ProductListScreen() {
//    val productList = listOf(
//        Product(1, "Smartphone", 599.99),
//        Product(2, "Laptop", 1299.99),
//        Product(3, "A", 599.99),
//        Product(4, "B", 1299.99),
//        Product(5, "C", 599.99),
//        Product(6, "D", 1299.99),
//        Product(7, "E", 599.99)
//    )
//
//    // Pastikan selalu ada 10 items dalam list
//    val fixedSize = 10
//    val displayProductList = if (productList.size > fixedSize) {
//        productList.subList(0, fixedSize)  // Ambil hanya fixedSize pertama dari productList
//    } else {
//        productList.toMutableList().apply {
//            while (this.size < fixedSize) {
//                this.add(Product(null, null, null))  // Tambahkan item kosong jika kurang dari fixedSize
//            }
//        }
//    }
//
//    LazyColumn {
//        items(displayProductList.chunked(2)) { chunkedProducts ->
//            Row(modifier = Modifier.fillMaxWidth()) {
//                chunkedProducts.forEach { product ->
//                    if (product.id != null) {
//                        ProductItem(product) { selectedProduct ->
//                            println("Click on: ${selectedProduct.name} that Cost: ${selectedProduct.price}")
//                        }
//                        Spacer(modifier = Modifier.width(8.dp)) // Add space between items
//                    } else {
//                        EmptyProductItem()  // Tampilkan kotak kosong
//                    }
//                }
//            }
//        }
//    }
//}
//
//
//@Composable
//fun ProductItem(product: Product, onItemClick: (Product) -> Unit) {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .width(200.dp) //sesuaikan dengan ukuran tengah dari container
//            //semisal ukuran container 200 atur sekitar 90 (itung bagian space juga)
//            .clickable { onItemClick(product) },
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 4.dp
//        )
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = product.name ?: "", fontSize = 30.sp)
//            Text(text = "${product.price ?: ""}", fontWeight = FontWeight.Bold)
//        }
//    }
//}
//
//@Composable
//fun EmptyProductItem() {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .width(200.dp),
//        elevation = CardDefaults.cardElevation(
//            defaultElevation = 4.dp
//        )
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = "", fontSize = 30.sp)
//            Text(text = "", fontWeight = FontWeight.Bold)
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewProductListScreen() {
//    ProductListScreen()
//}
