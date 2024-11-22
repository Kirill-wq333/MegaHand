package com.example.megahandapp.ui.retrofit

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.megahand.ui.BrandItem
import com.example.megahand.ui.CollectionItem
import com.example.megahand.ui.StoriesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _stories: MutableStateFlow<List<StoriesItem>> = MutableStateFlow(listOf())
    val stories = _stories.asStateFlow()

    private val _collection: MutableStateFlow<List<CollectionItem>> = MutableStateFlow(listOf())
    val collection = _collection.asStateFlow()

    private val _brands: MutableStateFlow<List<BrandItem>> = MutableStateFlow(listOf())
    val brands = _brands.asStateFlow()

    fun getStories() {
        viewModelScope.launch(Dispatchers.IO) {
            val rawStories = RetrofitClient.apiService.getStories()
            val storiesList = rawStories.map { StoriesItem(image = it.photo, name = it.title) }
            _stories.emit(storiesList)
        }
    }

    fun getCollection() {
        viewModelScope.launch(Dispatchers.IO) {
            val rawCollection = RetrofitClient.apiService.getCollection()
            val collectionList = rawCollection.map { CollectionItem(image = it.images) }
            _collection.emit(collectionList)
        }
    }

    fun getBrands(){
        viewModelScope.launch(Dispatchers.IO) {
            val rawBrands = RetrofitClient.apiService.getBrands()
            val brandsList = rawBrands.map { BrandItem(image = it.logo) }
            _brands.emit(brandsList)
        }
    }
}
