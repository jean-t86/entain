package me.tadebois.entain

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.tadebois.entain.db.Race
import me.tadebois.entain.repository.RaceRepository
import javax.inject.Inject

@HiltViewModel
class RaceViewModel @Inject constructor(private val raceRepository: RaceRepository) : ViewModel() {
    private val _updatedRaces = MutableLiveData<List<Race>>()
    val updatedRaces: LiveData<List<Race>> = _updatedRaces

    private val _races = mutableStateListOf<Race>()
    val races: SnapshotStateList<Race> = _races

    init {
        observeRaces()
    }

    private fun observeRaces() {
        viewModelScope.launch {
            raceRepository.getAllRaces().collect { races ->
                _races.clear()
                _races.addAll(races)
                racesUpdated()
            }
        }
    }

    private fun racesUpdated() {
        _updatedRaces.value = _races.toList()
    }
}
