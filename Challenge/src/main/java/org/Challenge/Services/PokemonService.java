package org.Challenge.Services;

import com.google.gson.Gson;
import dev.jocalomo.challenge.*;
import org.Challenge.Entities.AbilitiesEntity;
import org.Challenge.Entities.BitacoraEntity;
import org.Challenge.Entities.PokemonEntity;
import org.Challenge.Repositories.BitacoraRepository;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.math.BigInteger;

@Service
public class PokemonService {

    public final String urlPokemonApi = "https://pokeapi.co/api/v2/pokemon/";
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final BitacoraRepository bitacoraRepository;

    public PokemonService(BitacoraRepository bitacoraRepository) {
        this.bitacoraRepository = bitacoraRepository;
    }

    public void saveRequest(BitacoraEntity bitacoraEntity) {
        this.bitacoraRepository.save(bitacoraEntity);
    }

    @PreDestroy
    public void close() {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PokemonEntity getPokemonRequest(String name) throws Exception {
        HttpGet request = new HttpGet(urlPokemonApi + "/" + name);
        try{
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            Gson gson = new Gson();
            return gson.fromJson(result, PokemonEntity.class);
        } finally {
            this.close();
        }
    }

    public GetPokemonResponse getPokemon(String name) throws Exception {
        GetPokemonResponse response = new GetPokemonResponse();
        PokemonEntity pokemonEntity = this.getPokemonRequest(name);
        try {
            if (pokemonEntity != null) {
                Pokemon pokemon = new Pokemon();
                pokemon.setName(pokemonEntity.getName());
                pokemon.setBaseExperience(BigInteger.valueOf(pokemonEntity.getBase_experience()));
                pokemon.setId(BigInteger.valueOf(pokemonEntity.getId()));
                pokemon.setLocationAreaEncounters(pokemonEntity.getLocation_area_encounters());

                for (AbilitiesEntity abilitiesEntity : pokemonEntity.getAbilities()) {
                    Abilities abilities = new Abilities();
                    abilities.setSlot(BigInteger.valueOf(abilitiesEntity.getSlot()));
                    abilities.setIdHiden(abilitiesEntity.getId_hiden());
                    Ability ability = new Ability();
                    ability.setName(abilitiesEntity.getAbility().getName());
                    ability.setUrl(abilitiesEntity.getAbility().getUrl());
                    abilities.setAbility(ability);
                    pokemon.getAbilities().add(abilities);
                }
                response.setPokemon(pokemon);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public GetPokemonResponse getAbilities(String name) throws Exception {
        GetPokemonResponse response = new GetPokemonResponse();
        PokemonEntity pokemonEntity = this.getPokemonRequest(name);
        try {
            if (pokemonEntity != null) {
                Pokemon pokemon = new Pokemon();
                for (AbilitiesEntity abilitiesEntity : pokemonEntity.getAbilities()) {
                    Abilities abilities = new Abilities();
                    abilities.setSlot(BigInteger.valueOf(abilitiesEntity.getSlot()));
                    abilities.setIdHiden(abilitiesEntity.getId_hiden());
                    Ability ability = new Ability();
                    ability.setName(abilitiesEntity.getAbility().getName());
                    ability.setUrl(abilitiesEntity.getAbility().getUrl());
                    abilities.setAbility(ability);
                    pokemon.getAbilities().add(abilities);
                }
                response.setPokemon(pokemon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
