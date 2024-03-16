package org.example.demo112.model;

public class TypeVehicle {
    private int idTypeVehicle;
    private String nameTablePermission;

    public TypeVehicle() {
    }

    public TypeVehicle(int idTypeVehicle) {
        this.idTypeVehicle = idTypeVehicle;
    }

    public int getIdTypeVehicle() {
        return idTypeVehicle;
    }

    public void setIdTypeVehicle(int idTypeVehicle) {
        this.idTypeVehicle = idTypeVehicle;
    }

    public String getNameTablePermission() {
        return nameTablePermission;
    }

    public void setNameTablePermission(String nameTablePermission) {
        this.nameTablePermission = nameTablePermission;
    }
}
