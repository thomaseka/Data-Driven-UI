//This shit work 100% perfect
//package com.example.buttondaridatabase
//
//import android.widget.Toast
//import androidx.compose.foundation.Canvas
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.geometry.Offset
//import androidx.compose.ui.geometry.Size
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Color.Companion.Blue
//import androidx.compose.ui.graphics.Color.Companion.Gray
//import androidx.compose.ui.graphics.Color.Companion.Red
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.platform.LocalDensity
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//
//@Preview(showBackground = true)
//@Composable
//fun RectMaster() {
//    val context = LocalContext.current
//    DrawRectangle(75f, 10f, 100.dp, 100.dp, Blue) {
//    // Show a toast message when the rectangle is clicked
//        Toast.makeText(context, "Welcome! Blue", Toast.LENGTH_SHORT).show()
//    }
//    DrawRectangle(200f, 300f, 100.dp, 100.dp, Gray) {
//        Toast.makeText(context, "Welcome! Gray", Toast.LENGTH_SHORT).show()
//    }
//    DrawRectangle(100f, 10f, 100.dp, 100.dp, Red) {
//        Toast.makeText(context, "Welcome! Red", Toast.LENGTH_SHORT).show()
//    }
//}
//
//@Composable
//fun DrawRectangle(
//    top: Float, left: Float, width: Dp, height: Dp, colorItem: Color, onClick: () -> Unit
//) {
//    val density = LocalDensity.current
//    Canvas(
//        modifier = Modifier
//            .padding(top = top.dp, start = left.dp)
//            .size(width, height)
//            .clickable(onClick = onClick)
//    ) {
//        val sizePx = with(density) { Size(width.toPx(), height.toPx()) }
//        drawRect(
//            color = colorItem, size = sizePx
//        )
//    }
//}