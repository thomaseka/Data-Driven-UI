package com.example.buttondaridatabase.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "MsButtonAndroid")
data class RectParams(
    @PrimaryKey @ColumnInfo(name = "ID")
    val id: String,

    @ColumnInfo(name = "DesignID")
    val designId: String,

    @ColumnInfo(name = "Parent")
    val parent: String,

    @ColumnInfo(name = "MenuID")
    val menuId: String,

    @ColumnInfo(name = "Line1")
    val line1: String = "",

    @ColumnInfo(name = "Line2")
    val line2: String = "",

    @ColumnInfo(name = "Top")
    val top: Int,

    @ColumnInfo(name = "MarginLeft")
    val left: Int,

    @ColumnInfo(name = "Width")
    val width: Int,

    @ColumnInfo(name = "Height")
    val height: Int,

    @ColumnInfo(name = "BtnColour")
    val colorItem: String,
)

//    @ColumnInfo(name = "Ancestor")
//    val ancestor: String, // Add the missing field

//@Entity(tableName = "MSBtnLocation", primaryKeys = ["ID", "DesignID"])
//data class RectParams(
//    @ColumnInfo(name = "ID")
//    val id: String,
//
//    @ColumnInfo(name = "DesignID")
//    val designID: String,
//
//    @ColumnInfo(name = "Ancestor")
//    val ancestor: String,
//
//    @ColumnInfo(name = "Parent")
//    val parent: String,
//
//    @ColumnInfo(name = "MenuID")
//    val menuId: String,
//
//    @ColumnInfo(name = "Line1")
//    val line1: String? = null,
//
//    @ColumnInfo(name = "Line2")
//    val line2: String? = null,
//
//    @ColumnInfo(name = "HideLabel")
//    val hideLabel: String = "N",
//
//    @ColumnInfo(name = "Icon")
//    val icon: String? = null,
//
//    @ColumnInfo(name = "Top")
//    val top: Int = 1,
//
//    @ColumnInfo(name = "[Left]")
//    val left: Int = 1,
//
//    @ColumnInfo(name = "Width")
//    val width: Int = 1,
//
//    @ColumnInfo(name = "Height")
//    val height: Int = 1,
//
//    @ColumnInfo(name = "FontName")
//    val fontName: String? = null,
//
//    @ColumnInfo(name = "FontSize")
//    val fontSize: Int = 10,
//
//    @ColumnInfo(name = "FontColor")
//    val fontColor: String,
//
//    @ColumnInfo(name = "FontBold")
//    val fontBold: String,
//
//    @ColumnInfo(name = "FontItalic")
//    val fontItalic: String,
//
//    @ColumnInfo(name = "BtnColour")
//    val colorItem: String,
//
//    @ColumnInfo(name = "BtnEndColour")
//    val btnEndColour: String? = null,
//
//    @ColumnInfo(name = "Created")
//    val created: String,
//
//    @ColumnInfo(name = "_SecurityLevel")
//    val securityLevel: String? = null,
//
//    @ColumnInfo(name = "_KeyPositionrequired")
//    val keyPositionRequired: String? = null,
//
//    @ColumnInfo(name = "MsContainerLocationID")
//    val msContainerLocationID: String? = null,
//
//    @ColumnInfo(name = "Properties")
//    val properties: String? = null,
//
//    @ColumnInfo(name = "Who")
//    val who: String,
//
//    @ColumnInfo(name = "Last")
//    val last: String
//)

//
////    @ColumnInfo(name = "FontItalic")
////    val fontItalic: String = "N", // Provide default value
////
////    @ColumnInfo(name = "FontBold")
////    val fontBold: String = "N", // Provide default value
////
////    @ColumnInfo(name = "Properties")
////    val properties: String? = null, // Add nullable property
////
////    @ColumnInfo(name = "HideLabel")
////    val hideLabel: String = "N", // Provide default value
////
////    @ColumnInfo(name = "Icon")
////    val icon: String? = null, // Add nullable property
////
////    @ColumnInfo(name = "Created")
////    val created: String,
////
////    @ColumnInfo(name = "Last")
////    val last: String,
////
////    @ColumnInfo(name = "BtnEndColour")
////    val btnEndColour: String? = null, // Add nullable property
////
////    @ColumnInfo(name = "Who")
////    val who: String,
////
////    @ColumnInfo(name = "_SecurityLevel")
////    val securityLevel: String? = null, // Add nullable property
////
////    @ColumnInfo(name = "_KeyPositionrequired")
////    val keyPositionRequired: String? = null, // Add nullable property
////
////    @ColumnInfo(name = "FontColor")
////    val fontColor: String,
////
////    @ColumnInfo(name = "FontSize")
////    val fontSize: Int
//)


//@Entity(tableName = "MSBtnLocation")
//data class RectParams(
//
//    @PrimaryKey @ColumnInfo(name = "ID")
//    val id: String,
//
//    @ColumnInfo(name = "DesignID")
//    val designId: String,
//
//    @ColumnInfo(name = "Parent")
//    val parent:String,
//
//    @ColumnInfo(name = "MenuID")
//    val menuId: String,
//
//    @ColumnInfo(name = "Line1")
//    val line1: String,
//
//    @ColumnInfo(name = "Line2")
//    val line2: String,
//
//    @ColumnInfo(name = "Top")
//    val top: Int,
//
//    @ColumnInfo(name = "Left")
//    val left: Int,
//
//    @ColumnInfo(name = "Width")
//    val width: Int,
//
//    @ColumnInfo(name = "Height")
//    val height: Int,
//
//    @ColumnInfo(name = "BtnColour")
//    val colorItem: String,
//)

//// Include any additional columns that are present in the actual schema but missing in your data class
//@ColumnInfo(name = "FontItalic")
//val fontItalic: String,
//
//@ColumnInfo(name = "FontBold")
//val fontBold: String,
//
//@ColumnInfo(name = "Properties")
//val properties: String?,
//
//@ColumnInfo(name = "HideLabel")
//val hideLabel: String,
//
//@ColumnInfo(name = "Created")
//val created: String,
//
//@ColumnInfo(name = "Last")
//val last: String,
//
//@ColumnInfo(name = "BtnEndColour")
//val btnEndColour: String,
//
//@ColumnInfo(name = "Who")
//val who: String,
//
//@ColumnInfo(name = "_SecurityLevel")
//val securityLevel: String?,
//
//@ColumnInfo(name = "_KeyPositionrequired")
//val keyPositionRequired: String?,
//
//@ColumnInfo(name = "FontColor")
//val fontColor: String,
//
//@ColumnInfo(name = "FontSize")
//val fontSize: Int
//{
//    val color: Color
//        get() = parseColor(colorItem)
//
//    val categoryName: String
//        get() = "$line1 $line2"
//
//    // Public constructor with no arguments for Room
//    constructor() : this("", "", "", "", "", "", 0, 0, 0, 0, "")
//}

//Udah jadi
//data class RectParams(
//    val top: Float,
//    val left: Float,
//    val width: Dp,
//    val height: Dp,
//    val colorItem: Color,
//    val catId: Int,
//    val cornerRadius: Float
//)
