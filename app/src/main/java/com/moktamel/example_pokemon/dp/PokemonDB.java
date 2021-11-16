package com.moktamel.example_pokemon.dp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.moktamel.example_pokemon.model.Pokemon;

@Database(entities = Pokemon.class, version = 1, exportSchema = false)
public abstract class PokemonDB extends RoomDatabase {

    public abstract PokemonDao pokemonDao();
}
