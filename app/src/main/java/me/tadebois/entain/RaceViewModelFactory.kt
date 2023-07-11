package me.tadebois.entain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RaceViewModelFactory @Inject constructor(private val raceRepository: RaceRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RaceViewModel::class.java)) {
            return RaceViewModel(raceRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
