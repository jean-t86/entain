package me.tadebois.entain

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RaceViewModel @Inject constructor(private val raceRepository: RaceRepository) :
    ViewModel() {

}
