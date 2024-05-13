package org.Challenge.Services;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    public List<String> getAbilities(String pokemonName) {
        // URL base de la API REST de Pokémon
        String baseUrl = "https://pokeapi.co/api/v2/pokemon/";

        // Construye la URL completa para obtener información sobre el Pokémon especificado
        String apiUrl = baseUrl + pokemonName.toLowerCase(); // La API de Pokémon espera nombres en minúsculas

        // Crea una instancia de RestTemplate para hacer la solicitud HTTP
        RestTemplate restTemplate = new RestTemplate();

        // Realiza una solicitud GET a la API de Pokémon y obtiene la respuesta
        Object response = restTemplate.getForObject(apiUrl, Object.class);

        List<String> abilitiesList = convertToObjectList(response);
        // Devuelve la respuesta
        return abilitiesList;
    }

    private List<String> convertToObjectList(Object abilitiesObject) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convertir el objeto a un nodo JSON
            JsonNode abilitiesNode = objectMapper.convertValue(abilitiesObject, JsonNode.class);

            // Obtener la lista de habilidades del nodo JSON
            JsonNode abilitiesArrayNode = abilitiesNode.path("abilities");

            // Crear una lista para almacenar las habilidades
            List<String> abilitiesList = new ArrayList<>();

            // Recorrer el array de habilidades y agregar cada habilidad a la lista
            for (JsonNode abilityNode : abilitiesArrayNode) {
                abilitiesList.add(abilityNode.path("ability").path("name").asText());
            }

            return abilitiesList;
        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la conversión
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
