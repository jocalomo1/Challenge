package org.Challenge.Controllers;

import org.Challenge.Services.PokemonService;
import org.Challenge.Soap.AbilitiesRequest;
import org.Challenge.Soap.AbilitiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import java.util.List;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PayloadRoot(namespace = "http://example.com/pokemon", localPart = "AbilitiesRequest")
    public AbilitiesResponse getAbilities(@RequestPayload AbilitiesRequest request) {
        // Llama al servicio para obtener las habilidades del Pokémon
        List<String> abilities = pokemonService.getAbilities(request.getPokemonName());
        // Convierte los datos obtenidos en una respuesta SOAP y devuelve
        return new AbilitiesResponse(abilities);
    }

}
