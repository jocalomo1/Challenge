package org.Challenge.Entities;

import java.util.ArrayList;

public class PokemonEntity {
    private ArrayList<AbilitiesEntity> abilities;
    private Integer base_experience;
    private ArrayList<HeldItemsEntity> heldItems;
    private Integer id;
    private String name;
    private String location_area_encounters;

    public PokemonEntity(ArrayList<AbilitiesEntity> abilities,
                         Integer base_experience,
                         ArrayList<HeldItemsEntity> heldItems,
                         Integer id,
                         String name,
                         String location_area_encounters)
    {
        this.abilities = abilities;
        this.base_experience = base_experience;
        this.heldItems = heldItems;
        this.id = id;
        this.name = name;
        this.location_area_encounters = location_area_encounters;
    }


}
