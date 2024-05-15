package org.Challenge.Entities;

public class HeldItemsEntity {
    private ItemEntity item;
    private VersionDetailEntity versionDetail;

    public HeldItemsEntity(ItemEntity item, VersionDetailEntity versionDetail) {
        this.item = item;
        this.versionDetail = versionDetail;
    }

    public ItemEntity getItem() {
        return item;
    }
    public void setItem(ItemEntity item) {
        this.item = item;
    }
    public VersionDetailEntity getVersionDetail() {
        return versionDetail;
    }
    public void setVersionDetail(VersionDetailEntity versionDetail) {
        this.versionDetail = versionDetail;
    }
}
