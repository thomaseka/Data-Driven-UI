package com.example.buttondaridatabase.repository

import android.util.Log
import com.example.buttondaridatabase.dao.MsButton
import com.example.buttondaridatabase.data.RectParams
import com.example.buttondaridatabase.databases.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext

class RectParamsRepository(private val msButtonDao: MsButton) {

    // Method to get all categories based on parent and designId
    suspend fun getAllCategories(): List<RectParams> {
        return try {
            withContext(Dispatchers.IO) {
                msButtonDao.getAllCategory()
            }
        } catch (e: Exception) {
            // Handle the error here
            Log.e("RectParamsRepository", "Error fetching categories: ${e.message}")
            emptyList() // Return an empty list or handle the error accordingly
        }
    }
}
