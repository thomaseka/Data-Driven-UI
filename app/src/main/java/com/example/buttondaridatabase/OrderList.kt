package com.example.buttondaridatabase

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.buttondaridatabase.viewmodel.ProductViewModel

@Composable
fun OrderItem (
    nomor : String,
    namaOrder : String,
    qty : Int,
    onClick : () -> Unit
) {
    Row(
        modifier = Modifier.size(178.dp,24.dp)
        .clickable(onClick = onClick)
    ) {
        val fontSize = 12.sp
        Text(
            text = nomor, modifier = Modifier
                .padding(4.dp),
            fontSize = fontSize
        )
        Text(
            text = namaOrder, modifier = Modifier
                .padding(4.dp),
            fontSize = fontSize
        )
        Text(
            text = qty.toString(), modifier = Modifier
                .padding(4.dp),
            fontSize = fontSize
        )
    }
}

@Composable
fun ListOrderItem(
    productViewModel: ProductViewModel,
    modifier: Modifier = Modifier,
    topPadding: Dp = 0.dp,
    startPadding: Dp = 0.dp
) {
    val products by productViewModel.allProducts.collectAsState(initial = emptyList())

    Box(modifier = modifier.padding(top = topPadding, start = startPadding)) {
        LazyColumn {
            items(products) { product ->
                OrderItem(
                    nomor = product.productId,
                    namaOrder = product.name,
                    qty = product.qty
                ) {
                    // Handle item click
                }
            }
        }
    }
}
//
//@Preview
//@Composable
//fun ListOrderItemPreview() {
//
//}
////@Composable
////fun ListOrderItem(productViewModel : ViewModel) {
////    val productViewModel by productViewModel.productViewModel.collectAsState()
////    LazyColumn(
////        content = {
////            items(contents) {
////                OrderItem(nomor = productViewModel.id, namaOrder = productViewModel.name, qty = productViewModel.qty) {
////
////                }
////            }
////        },
////
////        )
////}