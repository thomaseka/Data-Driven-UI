package com.example.buttondaridatabase.viewmodel

//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.example.buttondaridatabase.data.RectParams
//import com.example.buttondaridatabase.repository.RectParamsRepository
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.collect
//import kotlinx.coroutines.launch
//
//class RectParamsViewModel(private val repository: RectParamsRepository) : ViewModel() {
//    private val _rectParams = MutableStateFlow<List<RectParams>>(emptyList())
//    val rectParams = _rectParams
//
//    init {
//        fetchRectParams()
//    }
//
//    private fun fetchRectParams() {
//        viewModelScope.launch {
//            repository.getAllCategories(parent = "pnlMaster", designId = "RESTO").collect {
//                _rectParams.value = it
//            }
//        }
//    }
//}


import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.buttondaridatabase.data.RectParams
import com.example.buttondaridatabase.repository.RectParamsRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext

class RectParamsViewModel(private val repository: RectParamsRepository) : ViewModel() {
    private val _rectParams = MutableStateFlow<List<RectParams>>(emptyList())
    val rectParams: StateFlow<List<RectParams>> get() = _rectParams

    init {
        fetchRectParams()
    }

    private fun fetchRectParams() {
        viewModelScope.launch {
            try {
                val rectParams = withContext(Dispatchers.IO) {
                    repository.getAllCategories()
                }
                _rectParams.value = rectParams
            } catch (e: Exception) {
                Log.e("RectParamsViewModel", "Error fetching categories: ${e.message}")
            }
        }
    }
}

class RectParamsViewModelFactory(
    private val repository: RectParamsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RectParamsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RectParamsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
