package me.tadebois.entain

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.tadebois.entain.db.Race
import me.tadebois.entain.repository.RaceRepository
import javax.inject.Inject

@HiltViewModel
class RaceViewModel @Inject constructor(private val raceRepository: RaceRepository) : ViewModel() {
    private val _races = mutableStateListOf<Race>()
    val races: SnapshotStateList<Race> = _races

    init {
        getAllRaces()
    }

    fun getAllRaces() {
        viewModelScope.launch {
            _races.clear()
            _races.addAll(raceRepository.getAllRaces())
        }
    }

    fun addRace(race: Race) {
        viewModelScope.launch {
            _races.add(race)
            raceRepository.insertRace(race)
        }
    }
}
