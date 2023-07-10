package me.tadebois.entain

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.tadebois.entain.db.NextRacesDatabase
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    private val applicationScope = CoroutineScope(Dispatchers.Default)

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        applicationScope.launch {
            database =
                Room.databaseBuilder(
                    this@App,
                    NextRacesDatabase::class.java,
                    "next_races_db"
                ).build()
        }
    }

    companion object {
        lateinit var database: NextRacesDatabase
    }
}
