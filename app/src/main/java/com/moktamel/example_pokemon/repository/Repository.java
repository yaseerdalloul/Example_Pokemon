package com.moktamel.example_pokemon.repository;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;

import com.moktamel.example_pokemon.dp.PokemonDao;
import com.moktamel.example_pokemon.model.Pokemon;
import com.moktamel.example_pokemon.model.PokemonResponse;
import com.moktamel.example_pokemon.network.PokemonApiService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {

    private PokemonApiService pokemonApiService;
    private PokemonDao pokemonDao;

    @Inject
    public Repository(PokemonApiService pokemonApiService, PokemonDao pokemonDao) {
        this.pokemonApiService = pokemonApiService;
        this.pokemonDao = pokemonDao;
    }

    public Observable<PokemonResponse> getPokemons() {
        return pokemonApiService.getPokemons();
    }

    public void insertPokemon(Pokemon pokemon) {
        pokemonDao.insertPokemon(pokemon);
    }

    public void deletePokemon(String pokemonName) {
        pokemonDao.deletePokemon(pokemonName);
    }

    public LiveData<List<Pokemon>> getFavPokemon() {
        return pokemonDao.getAllPokemon();
    }
}
