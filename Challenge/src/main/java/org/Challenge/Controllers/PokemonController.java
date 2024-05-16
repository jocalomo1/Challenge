package org.Challenge.Controllers;

import dev.jocalomo.challenge.*;

import org.Challenge.Services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PokemonController {
    private static final String nps = "http://jocalomo.dev/challenge";
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = nps, localPart = "GetPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) throws Exception {
        return pokemonService.getPokemon(request.getName());
    }

   @PayloadRoot(namespace = nps, localPart = "GetAbilitiesRequest")
   @ResponsePayload
   public GetPokemonResponse getAbilities(@RequestPayload GetPokemonRequest request) throws Exception {
       return pokemonService.getAbilities(request.getName());
   }
}
