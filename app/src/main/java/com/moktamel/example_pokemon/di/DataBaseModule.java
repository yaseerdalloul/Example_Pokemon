package com.moktamel.example_pokemon.di;

import android.app.Application;

import androidx.room.Room;

import com.moktamel.example_pokemon.dp.PokemonDB;
import com.moktamel.example_pokemon.dp.PokemonDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataBaseModule {

    @Provides
    @Singleton
    public static PokemonDB pokemonDB(Application application) {
        return Room.databaseBuilder(application, PokemonDB.class, "fav_DB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static PokemonDao pokemonDao(PokemonDB pokemonDB) {
        return pokemonDB.pokemonDao();
    }
}
