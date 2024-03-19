package model;

import java.time.LocalDate;

public class OrderShipping {
    private int idOrder;
    private int collectionMoney;
    private int transportationCost;
    private LocalDate orderDate;
    private Boolean checkPackage;
    private Boolean statusOrder;
    private Address address;
    private String noteForShipper;
    private LocalDate estimatedDeliveryTime;

    public OrderShipping(int collectionMoney, int transportationCost, Boolean statusOrder, String noteForShipper) {
        this.collectionMoney = collectionMoney;
        this.transportationCost = transportationCost;
        this.statusOrder = statusOrder;
        this.noteForShipper = noteForShipper;
    }

    public OrderShipping() {
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getCollectionMoney() {
        return collectionMoney;
    }

    public void setCollectionMoney(int collectionMoney) {
        this.collectionMoney = collectionMoney;
    }

    public int getTransportationCost() {
        return transportationCost;
    }

    public void setTransportationCost(int transportationCost) {
        this.transportationCost = transportationCost;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Boolean getCheckPackage() {
        return checkPackage;
    }

    public void setCheckPackage(Boolean checkPackage) {
        this.checkPackage = checkPackage;
    }

    public Boolean getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(Boolean statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNoteForShipper() {
        return noteForShipper;
    }

    public void setNoteForShipper(String noteForShipper) {
        this.noteForShipper = noteForShipper;
    }

    public LocalDate getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDate estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
}
