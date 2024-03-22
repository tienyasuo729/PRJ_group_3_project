package org.example.shipping_services_for_everyone.model;

import java.time.LocalDate;

public class OrderShipping {
    private int idOrder;
    private UserAccount idSender;
    private UserAccount idReceiver;
    private int collectionMoney;
    private int transportationCost;
    private char statusOrder;
    private Address addressSender;
    private Address addressReceiver;
    private String noteForShipper;
    private LocalDate estimatedDeliveryTime;
    private Boolean checkPackage;
    private LocalDate orderDate;
    private AccountShipping idPickup;
    private AccountShipping idDelivery;

    public OrderShipping() {
    }

    public OrderShipping(UserAccount idSender, UserAccount idReceiver, int collectionMoney, int transportationCost, char statusOrder, Address addressSender, Address addressReceiver, String noteForShipper, LocalDate estimatedDeliveryTime, Boolean checkPackage, AccountShipping idPickup, AccountShipping idDelivery) {
        this.idSender = idSender;
        this.idReceiver = idReceiver;
        this.collectionMoney = collectionMoney;
        this.transportationCost = transportationCost;
        this.statusOrder = statusOrder;
        this.addressSender = addressSender;
        this.addressReceiver = addressReceiver;
        this.noteForShipper = noteForShipper;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.checkPackage = checkPackage;
        this.idPickup = idPickup;
        this.idDelivery = idDelivery;
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

    public char getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(char statusOrder) {
        this.statusOrder = statusOrder;
    }

    public Address getAddressSender() {
        return addressSender;
    }

    public void setAddressSender(Address addressSender) {
        this.addressSender = addressSender;
    }

    public Address getAddressReceiver() {
        return addressReceiver;
    }

    public void setAddressReceiver(Address addressReceiver) {
        this.addressReceiver = addressReceiver;
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
