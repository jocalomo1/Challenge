package org.Challenge.Entities;

import java.util.ArrayList;

public class HeldItemsEntity {
    private ItemEntity item;
    private ArrayList<VersionDetailEntity> version_details;

    public HeldItemsEntity(ItemEntity item, ArrayList<VersionDetailEntity> version_details) {
        this.item = item;
        this.version_details = version_details;
    }

    public ItemEntity getItem() {
        return item;
    }
    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public ArrayList<VersionDetailEntity> getVersion_details() {
        return version_details;
    }
    public void setVersion_details(ArrayList<VersionDetailEntity> version_details) {
        this.version_details = version_details;
    }
}
