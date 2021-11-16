package com.moktamel.example_pokemon.network;



import com.moktamel.example_pokemon.model.PokemonResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokemonApiService {

    @GET("pokemon")
    Observable<PokemonResponse> getPokemons();
}