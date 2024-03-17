package org.example.shipping_services_for_everyone.model;

import java.time.LocalDate;

public class OrderShipping {
    private int idOrder;
    private UserAccount idSender;
    private UserAccount idReceiver;
    private int collectionMoney;
    private int transportationCost;
    private LocalDate orderDate;
    private Boolean checkPackage;
    private Boolean statusOrder;
    private Address address;
    private String noteForShipper;
    private LocalDate estimatedDeliveryTime;
    private AccountShipping idPickup;
    private AccountShipping idDelivery;

    public OrderShipping() {
    }

    public UserAccount getIdSender() {
        return idSender;
    }

    public void setIdSender(UserAccount idSender) {
        this.idSender = idSender;
    }

    public UserAccount getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(UserAccount idReceiver) {
        this.idReceiver = idReceiver;
    }

    public AccountShipping getIdPickup() {
        return idPickup;
    }

    public void setIdPickup(AccountShipping idPickup) {
        this.idPickup = idPickup;
    }

    public AccountShipping getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(AccountShipping idDelivery) {
        this.idDelivery = idDelivery;
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
