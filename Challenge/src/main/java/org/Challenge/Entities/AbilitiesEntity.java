package org.Challenge.Entities;

public class AbilitiesEntity {
    private Boolean id_hiden;
    private Integer slot;
    private AbilityEntity ability;

    public AbilitiesEntity(boolean id_hiden, Integer slot, AbilityEntity ability) {
        this.id_hiden = id_hiden;
        this.slot = slot;
        this.ability = ability;
    }

    public Boolean getId_hiden() {
        return id_hiden;
    }

    public void setId_hiden(Boolean id_hiden) {
        this.id_hiden = id_hiden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public AbilityEntity getAbility() {
        return ability;
    }

    public void setAbility(AbilityEntity ability) {
        this.ability = ability;
    }
}
