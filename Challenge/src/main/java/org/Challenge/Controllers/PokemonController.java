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
   public GetPokemonResponse getAbilities(@RequestPayload GetAbilitiesRequest request) throws Exception {
       return pokemonService.getAbilities(request.getName());
   }

    @PayloadRoot(namespace = nps, localPart = "GetBaseExperienceRequest")
    @ResponsePayload
    public GetPokemonResponse GetBaseExperience(@RequestPayload GetBaseExperienceRequest request) throws Exception {
        return pokemonService.GetBaseExperience(request.getName());
    }

    @PayloadRoot(namespace = nps, localPart = "GetIdRequest")
    @ResponsePayload
    public GetPokemonResponse GetId(@RequestPayload GetIdRequest request) throws Exception {
        return pokemonService.GetId(request.getName());
    }

    @PayloadRoot(namespace = nps, localPart = "GetNameRequest")
    @ResponsePayload
    public GetPokemonResponse GetName(@RequestPayload GetNameRequest request) throws Exception {
        return pokemonService.GetName(request.getName());
    }

    @PayloadRoot(namespace = nps, localPart = "GetLocationAreaEncountersRequest")
    @ResponsePayload
    public GetPokemonResponse GetLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) throws Exception {
        return pokemonService.GetLocationAreaEncounters(request.getName());
    }

    @PayloadRoot(namespace = nps, localPart = "GetHeldItemsRequest")
    @ResponsePayload
    public GetPokemonResponse GetHeldItems(@RequestPayload GetHeldItemsRequest request) throws Exception {
        return pokemonService.GetHeldItems(request.getName());
    }
}
