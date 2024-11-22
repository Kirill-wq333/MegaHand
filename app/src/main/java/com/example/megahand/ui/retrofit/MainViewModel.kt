package com.example.megahandapp.ui.retrofit

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.megahand.ui.StoriesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _stories: MutableStateFlow<List<StoriesItem>> = MutableStateFlow(listOf())
    val stories = _stories.asStateFlow()

    fun getStories() {
        viewModelScope.launch(Dispatchers.IO) {
            val rawStories = RetrofitClient.apiService.getStories()
            val storiesList = rawStories.map { StoriesItem(image = it.photo, name = it.title) }
            _stories.emit(storiesList)
        }
    }

}

class UserViewModel : ViewModel() {

    private val _users = mutableStateListOf<CollectionsResponse>()
    val users: List<CollectionsResponse>
        get() = _users

    fun addUser(user: CollectionsResponse) {
        _users.add(user)
    }

}