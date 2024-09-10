package com.example.buttondaridatabase

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import android.graphics.Paint // Import Paint from Android
import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewModelScope
import com.example.buttondaridatabase.data.Product
import com.example.buttondaridatabase.viewmodel.ProductViewModel
import com.example.buttondaridatabase.viewmodel.RectParamsViewModel
import kotlinx.coroutines.launch


//@Preview(showBackground = true)
//@Composable
//fun RectMaster() {
//    val context = LocalContext.current
//    DrawRectangle(1f, 10f, 100.dp, 100.dp, Blue,"Thomas Ganteng Banget") {
//    // Show a toast message when the rectangle is clicked
//        Toast.makeText(context, "Welcome! Blue", Toast.LENGTH_SHORT).show()
//    }
//    DrawRectangle(100f, 10f, 100.dp, 100.dp, Red,"Saya sangat setuju sekali") {
//        Toast.makeText(context, "Welcome! Red", Toast.LENGTH_SHORT).show()
//    }
//    DrawRectangle(200f, 300f, 100.dp, 100.dp, Gray,"Jelas Lah") {
//        Toast.makeText(context, "Welcome! Gray", Toast.LENGTH_SHORT).show()
//    }

//    val categories = listOf(
//        Category(1, "Food"),
//        Category(2, "Drink"),
//        Category(3, "Product")
//    )
//    val rectangles = listOf(
//        RectParams(25f, 10f, 150.dp, 118.dp, Gray, 1, 16f),
//        RectParams(170f, 10f, 150.dp, 118.dp, Red, 2, 8f),
//        RectParams(315f, 10f, 150.dp, 118.dp, Blue, 3, 8f),
//        RectParams(300f, 300f, 100.dp, 100.dp, Green, 3, 8f)
//    )


//----------------------------------------yang udah bisa-----------------------------------------------------
//This work good
//    val context = LocalContext.current
//    val rectangles = listOf(
//        RectParams(25f, 10f, 150.dp, 118.dp, Gray, "Drink", 16f),
//        RectParams(170f, 10f, 150.dp, 118.dp, Red, "Food", 8f),
//        RectParams(315f, 10f, 150.dp, 118.dp, Blue, "Product", 8f),
//        RectParams(300f, 300f, 100.dp, 100.dp, Green, "Product", 8f)
//    )
//
//    Box() {
//        rectangles.forEach { params ->
//            DrawRectangle(
//                top = params.top,
//                left = params.left,
//                width = params.width,
//                height = params.height,
//                colorItem = params.colorItem,
//                text = params.category,
//                cornerRadius = params.cornerRadius
//            ) {
//                Toast.makeText(context, "Welcome! ${params.colorItem}", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//}
//
//@Composable
//fun DrawRectangle(
//    top: Float, left: Float, width: Dp, height: Dp, colorItem: Color, text: String, cornerRadius: Float, onClick: () -> Unit
//) {
//    val density = LocalDensity.current
//    Canvas(
//        modifier = Modifier
//            .padding(top = top.dp, start = left.dp)
//            .size(width, height)
//            .clickable(onClick = onClick)
//    ) {
//        val sizePx = with(density) { Size(width.toPx(), height.toPx()) }
//
//        // Draw the rectangle
//        drawRoundRect(color = colorItem, size = sizePx, cornerRadius = CornerRadius(cornerRadius))
//
//        // Draw text inside the rectangle
//        drawContext.canvas.nativeCanvas.drawText(
//            text,
//            sizePx.width / 2, // x-coordinate
//            sizePx.height / 2, // y-coordinate
//            Paint().apply {
//                color = Color.Black.toArgb()
//                textSize = 24f// adjust text size as needed
//                textAlign = Paint.Align.CENTER
//                isFakeBoldText = true
//            }
//        )
//    }
//}




////latest try
//@Composable
//fun RectMasterScreen(viewModel: RectParamsViewModel) {
//    // Observe LiveData from the ViewModel
//    val rectParams by viewModel.rectParams.collectAsState()
//
//    Box() {
//        rectParams.forEach { params ->
//            val categoryName = "${params.line1} ${params.line2}"
//            DrawRectangle(
//                top = pxToDp(params.top),
//                left = pxToDp(params.left),
//                width = pxToDp(params.width),
//                height = pxToDp(params.height),
//                colorItem = convertHexColor(params.colorItem),
//                categoryName = categoryName,
//                onClick = {
//                    // Optionally, you can perform any other actions here
//                    showMenuId(params.menuId)
//                }
//            )
//        }
//    }
//}


//latest try and using ProductViewModel
@Composable
fun RectMasterScreen(viewModel: RectParamsViewModel, productViewModel: ProductViewModel) {
    // Observe LiveData from the ViewModel
    val rectParams by viewModel.rectParams.collectAsState()

    Box() {
        rectParams.forEach { params ->
            val categoryName = "${params.line1} ${params.line2}"
            DrawRectangle(
                top = pxToDp(params.top),
                left = pxToDp(params.left),
                width = pxToDp(params.width),
                height = pxToDp(params.height),
                colorItem = convertHexColor(params.colorItem),
                categoryName = categoryName,
                onClick = { // Call the function to insert data into the other table
                    val newProduct = Product(
                        productId = params.menuId,
                        name = categoryName
                    )
                    // Call the function to insert data into the other table
                    productViewModel.insertProduct(newProduct)
                    // Optionally, you can perform any other actions here
                    showMenuId(params.menuId)
                }
            )
        }
    }
}


@Composable
fun DrawRectangle(
    top: Dp,
    left: Dp,
    width: Dp,
    height: Dp,
    colorItem: Color,
    categoryName: String,
    onClick: () -> Unit
) {
    val density = LocalDensity.current
    Canvas(
        modifier = Modifier
            .padding(top = top, start = left)
            .size(width, height)
            .clickable(onClick = onClick)
    ) {
        val sizePx = with(density) { Size(width.toPx(), height.toPx()) }

        // Draw the rectangle
        drawRoundRect(
            color = colorItem,
            size = sizePx,
            cornerRadius = CornerRadius(24f)
        )

        // Draw text inside the rectangle
        drawContext.canvas.nativeCanvas.drawText(
            categoryName,
            sizePx.width / 2, // x-coordinate
            sizePx.height / 2, // y-coordinate
            Paint().apply {
                color = Color.Black.toArgb()
                textSize = 22f // adjust text size as needed
                textAlign = Paint.Align.CENTER
                isFakeBoldText = true
            }
        )
    }
}

// Function to show the menuId when an item is clicked
fun showMenuId(menuId: String) {
    // Handle showing the menuId in your UI layer
    // For example, you can update a UI component or trigger navigation
    println("Menu ID: $menuId")
}

fun pxToDp(px: Int, dpi: Int = 240): Dp {
//    return (px.toFloat() / (dpi / 160f)).dp
    return try {
        (px.toFloat() / (dpi / 160f)).dp
    } catch (e: Exception) {
        Log.e("pxToDp", "Error converting px to dp: ${e.message}")
        0.dp
    }
}


fun convertHexColor(hexColor: String): Color {
//    // Ensure the hex color starts with $
//    require(hexColor.startsWith("$")) { "Color should start with $" }
//
//    // Convert from $AARRGGBB to #AARRGGBB
//    val formattedColor = "0x" + hexColor.substring(1)
//    return Color(android.graphics.Color.parseColor(formattedColor))
    return try {
        require(hexColor.startsWith("$")) { "Color should start with $" }
        val formattedColor = "#" + hexColor.substring(1)
        Color(android.graphics.Color.parseColor(formattedColor))
    } catch (e: Exception) {
        Log.e("convertHexColor", "Error converting hex color: ${e.message}")
        Color.Black
    }
}

