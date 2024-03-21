package org.example.shipping_services_for_everyone.model;

public class Package {
    private String nameItem;
    private Size sizeItem;
    private Image imageItem;

    public Package() {
    }

    public Package(String nameItem, Size sizeItem, Image imageItem) {
        this.nameItem = nameItem;
        this.sizeItem = sizeItem;
        this.imageItem = imageItem;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public Size getSizeItem() {
        return sizeItem;
    }

    public void setSizeItem(Size sizeItem) {
        this.sizeItem = sizeItem;
    }

    public Image getImageItem() {
        return imageItem;
    }

    public void setImageItem(Image imageItem) {
        this.imageItem = imageItem;
    }
}
