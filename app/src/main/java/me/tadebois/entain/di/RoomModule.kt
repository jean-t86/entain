package me.tadebois.entain.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import me.tadebois.entain.db.NextRacesDatabase
import me.tadebois.entain.db.RaceDao

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NextRacesDatabase {
        return Room.databaseBuilder(
            context,
            NextRacesDatabase::class.java,
            "next_races_db"
        ).build()
    }

    @Provides
    fun provideRaceDao(appDatabase: NextRacesDatabase): RaceDao {
        return appDatabase.raceDao()
    }
}
