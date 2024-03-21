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
    private String receiverName;
    private String receiverPhoneNum;

//    public OrderShipping(int collectionMoney, int transportationCost, Boolean statusOrder, String noteForShipper) {
//        this.collectionMoney = collectionMoney;
//        this.transportationCost = transportationCost;
//        this.statusOrder = statusOrder;
//        this.noteForShipper = noteForShipper;
//    }
    
    public OrderShipping(int collectionMoney, int transportationCost, LocalDate orderDate, Boolean checkPackage, Boolean statusOrder, Address address, String noteForShipper, String receiverName, String receiverPhoneNum) {
        this.collectionMoney = collectionMoney;
        this.transportationCost = transportationCost;
        this.orderDate = orderDate;
        this.checkPackage = checkPackage;
        this.statusOrder = statusOrder;
        this.address = address;
        this.noteForShipper = noteForShipper;
        this.receiverName = receiverName;
        this.receiverPhoneNum = receiverPhoneNum;
    }

//    public OrderShipping(int collectionMoney, int transportationCost, LocalDate orderDate, Boolean checkPackage, Boolean statusOrder, Address address, String noteForShipper) {
//        this.collectionMoney = collectionMoney;
//        this.transportationCost = transportationCost;
//        this.orderDate = orderDate;
//        this.checkPackage = checkPackage;
//        this.statusOrder = statusOrder;
//        this.address = address;
//        this.noteForShipper = noteForShipper;
//    }
    public OrderShipping() {
    }

    

    public OrderShipping(int idOrder, int collectionMoney, int transportationCost, Boolean checkPackage, Boolean statusOrder, Address address, String noteForShipper, String receiverName, String receiverPhoneNum) {
        this.idOrder = idOrder;
        this.collectionMoney = collectionMoney;
        this.transportationCost = transportationCost;
        this.checkPackage = checkPackage;
        this.statusOrder = statusOrder;
        this.address = address;
        this.noteForShipper = noteForShipper;
        this.receiverName = receiverName;
        this.receiverPhoneNum = receiverPhoneNum;
    }

    public LocalDate getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(LocalDate estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhoneNum() {
        return receiverPhoneNum;
    }

    public void setReceiverPhoneNum(String receiverPhoneNum) {
        this.receiverPhoneNum = receiverPhoneNum;
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

 

  
}