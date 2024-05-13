package org.Challenge.Soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AbilitiesRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class AbilitiesRequest {

    private String pokemonName;

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
}