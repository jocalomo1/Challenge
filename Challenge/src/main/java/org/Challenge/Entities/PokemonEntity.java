package org.Challenge.Entities;

import java.util.ArrayList;

public class PokemonEntity {
    private ArrayList<AbilitiesEntity> abilities;
    private Integer base_experience;
    private ArrayList<HeldItemsEntity> held_items;
    private Integer id;
    private String name;
    private String location_area_encounters;

    public PokemonEntity(ArrayList<AbilitiesEntity> abilities,
                         Integer base_experience,
                         ArrayList<HeldItemsEntity> held_items,
                         Integer id,
                         String name,
                         String location_area_encounters)
    {
        this.abilities = abilities;
        this.base_experience = base_experience;
        this.held_items = held_items;
        this.id = id;
        this.name = name;
        this.location_area_encounters = location_area_encounters;
    }

    public ArrayList<AbilitiesEntity> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<AbilitiesEntity> abilities) {
        this.abilities = abilities;
    }

    public Integer getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(Integer base_experience) {
        this.base_experience = base_experience;
    }

    public ArrayList<HeldItemsEntity> getHeldItems() {
        return held_items;
    }

    public void setHeldItems(ArrayList<HeldItemsEntity> heldItems) {
        this.held_items = heldItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public void setLocation_area_encounters(String location_area_encounters) {
        this.location_area_encounters = location_area_encounters;
    }


}
