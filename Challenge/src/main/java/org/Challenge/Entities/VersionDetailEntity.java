package org.Challenge.Entities;

public class VersionDetailEntity {
    private Integer rarity;
    private VersionEntity version;

    public VersionDetailEntity(Integer rarity, VersionEntity version) {
        this.rarity = rarity;
        this.version = version;
    }

    public Integer getRarity() {
        return rarity;
    }
    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }
    public VersionEntity getVersion() {
        return version;
    }
    public void setVersion(VersionEntity version) {
        this.version = version;
    }
}
