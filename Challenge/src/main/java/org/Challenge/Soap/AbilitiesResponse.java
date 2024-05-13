package org.Challenge.Soap;

import java.util.List;

public class AbilitiesResponse {

    private List<String> abilities;

    public AbilitiesResponse() {
    }

    public AbilitiesResponse(List<String> abilities) {
        this.abilities = abilities;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }
}