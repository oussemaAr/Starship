package io.studio.demoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.studio.demoapp.di.Injectors
import io.studio.demoapp.domain.AppRepository
import io.studio.demoapp.domain.model.StarShip
import kotlinx.coroutines.launch

class MainViewModel(

) : ViewModel() {

    private var _viewState = MutableLiveData<List<StarShip>>()
    val viewState: LiveData<List<StarShip>> = _viewState
    private val repository: AppRepository = Injectors().repository


    fun loadStartShips(max: Int) = viewModelScope.launch {
        try {
            _viewState.value = repository.fetchStarShip(max)
        } catch (ex: Exception) {
            _viewState.value = emptyList()
        }
    }

}