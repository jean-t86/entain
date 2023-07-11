package me.tadebois.entain

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.tadebois.entain.db.Race
import javax.inject.Inject

@HiltViewModel
class RaceViewModel @Inject constructor(private val raceRepository: RaceRepository) :
    ViewModel() {
    val races: SnapshotStateList<Race> = mutableStateListOf()

    fun addRace(race: Race) {
        viewModelScope.launch(Dispatchers.IO) {
            raceRepository.insertRace(race)
        }
    }

    fun getAllRaces() {
        viewModelScope.launch(Dispatchers.IO) {
            val allRaces = raceRepository.getAllRaces()
            races.clear()
            races.addAll(allRaces)
        }
    }
}
