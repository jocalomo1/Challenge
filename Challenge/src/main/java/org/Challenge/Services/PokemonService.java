package org.Challenge.Services;

import com.google.gson.Gson;
import dev.jocalomo.challenge.*;
import org.Challenge.Entities.*;
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
        System.out.println("Saving request");
        this.bitacoraRepository.save(bitacoraEntity);
        System.out.println("Saving Done");
    }

    public void close() {
        try {
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PokemonEntity getPokemonRequest(String name) throws Exception {
        HttpGet request = new HttpGet(urlPokemonApi + "/" + name);
        CloseableHttpResponse response = null;
        try{
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            Gson gson = new Gson();
            return gson.fromJson(result, PokemonEntity.class);
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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

                for (HeldItemsEntity heldItemsEntity : pokemonEntity.getHeldItems()){
                    HeldItem heldItem = new HeldItem();
                    Item item = new Item();
                    item.setName(heldItemsEntity.getItem().getName());
                    item.setUrl(heldItemsEntity.getItem().getUrl());

                    for (VersionDetailEntity versionDetailEntity : heldItemsEntity.getVersion_details()){
                        Version version = new Version();
                        version.setName(versionDetailEntity.getVersion().getName());
                        version.setUrl(versionDetailEntity.getVersion().getUrl());

                        VersionDetail versionDetail = new VersionDetail();
                        versionDetail.setVersion(version);
                        versionDetail.setRarity(BigInteger.valueOf(versionDetailEntity.getRarity()));
                        heldItem.getVersionDetails().add(versionDetail);
                    }
                    heldItem.setItems(item);
                    pokemon.getHeldItems().add(heldItem);
                }
                response.setPokemon(pokemon);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    public GetPokemonResponse GetBaseExperience(String name) throws Exception {
        GetPokemonResponse response = new GetPokemonResponse();
        PokemonEntity pokemonEntity = this.getPokemonRequest(name);
        try {
            if (pokemonEntity != null) {
                Pokemon pokemon = new Pokemon();
                pokemon.setBaseExperience(BigInteger.valueOf(pokemonEntity.getBase_experience()));
                response.setPokemon(pokemon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public GetPokemonResponse GetId(String name) throws Exception {
        GetPokemonResponse response = new GetPokemonResponse();
        PokemonEntity pokemonEntity = this.getPokemonRequest(name);
        try {
            if (pokemonEntity != null) {
                Pokemon pokemon = new Pokemon();
                pokemon.setId(BigInteger.valueOf(pokemonEntity.getId()));
                response.setPokemon(pokemon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public GetPokemonResponse GetName(String name) throws Exception {
        GetPokemonResponse response = new GetPokemonResponse();
        PokemonEntity pokemonEntity = this.getPokemonRequest(name);
        try {
            if (pokemonEntity != null) {
                Pokemon pokemon = new Pokemon();
                pokemon.setName(pokemonEntity.getName());
                response.setPokemon(pokemon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public GetPokemonResponse GetLocationAreaEncounters(String name) throws Exception {
        GetPokemonResponse response = new GetPokemonResponse();
        PokemonEntity pokemonEntity = this.getPokemonRequest(name);
        try {
            if (pokemonEntity != null) {
                Pokemon pokemon = new Pokemon();
                pokemon.setLocationAreaEncounters(pokemonEntity.getLocation_area_encounters());
                response.setPokemon(pokemon);
            }
        } catch (Exception e) {
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

    public GetPokemonResponse GetHeldItems(String name) throws Exception {
        GetPokemonResponse response = new GetPokemonResponse();
        PokemonEntity pokemonEntity = this.getPokemonRequest(name);
        try {
            if (pokemonEntity != null) {
                Pokemon pokemon = new Pokemon();
                for (HeldItemsEntity heldItemsEntity : pokemonEntity.getHeldItems()){
                    HeldItem heldItem = new HeldItem();
                    Item item = new Item();
                    item.setName(heldItemsEntity.getItem().getName());
                    item.setUrl(heldItemsEntity.getItem().getUrl());

                    for (VersionDetailEntity versionDetailEntity : heldItemsEntity.getVersion_details()){
                        Version version = new Version();
                        version.setName(versionDetailEntity.getVersion().getName());
                        version.setUrl(versionDetailEntity.getVersion().getUrl());

                        VersionDetail versionDetail = new VersionDetail();
                        versionDetail.setVersion(version);
                        versionDetail.setRarity(BigInteger.valueOf(versionDetailEntity.getRarity()));
                        heldItem.getVersionDetails().add(versionDetail);
                    }
                    heldItem.setItems(item);
                    pokemon.getHeldItems().add(heldItem);
                }
                response.setPokemon(pokemon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
