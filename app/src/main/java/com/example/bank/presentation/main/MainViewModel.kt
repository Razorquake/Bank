package com.example.bank.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bank.domain.repo.Details
import com.example.bank.domain.repo.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepo: MainRepo
): ViewModel() {
    private val _state = MutableStateFlow(MainScreenState())
    val state = _state.asStateFlow()
    val navigateToDetails = MutableStateFlow(false)

    val details: Details
        get() = state.value.details
    fun startScanning () {
        viewModelScope.launch {
            mainRepo.startScanning().collect{
                    _state.value = state.value.copy(
                        details = it
                    )
                navigateToDetails.emit(true)
                Log.d("MainViewModel", "Scanning completed, navigateToDetails emitted true")
            }
        }
    }
}