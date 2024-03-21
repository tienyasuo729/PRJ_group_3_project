package model;

import java.time.LocalDate;

public class OrderShipping {
    private int idOrder;
    private int idSender;
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
    private int idDelivery;
//    public OrderShipping(int collectionMoney, int transportationCost, Boolean statusOrder, String noteForShipper) {
//        this.collectionMoney = collectionMoney;
//        this.transportationCost = transportationCost;
//        this.statusOrder = statusOrder;
//        this.noteForShipper = noteForShipper;
//    }

    public OrderShipping(int idOrder, int collectionMoney, LocalDate orderDate, Boolean statusOrder, Address address, String noteForShipper, String receiverName, String receiverPhoneNum) {
        this.idOrder = idOrder;
        this.collectionMoney = collectionMoney;
        this.orderDate = orderDate;
        this.statusOrder = statusOrder;
        this.address = address;
        this.noteForShipper = noteForShipper;
        this.receiverName = receiverName;
        this.receiverPhoneNum = receiverPhoneNum;
    }

    public OrderShipping(int idSender, int collectionMoney, Boolean checkPackage,Boolean statusOrder, Address address, String noteForShipper, String receiverName, String receiverPhoneNum, int idDelivery) {
        this.idSender = idSender;
        this.collectionMoney = collectionMoney;
        this.checkPackage = checkPackage;
        this.address = address;
        this.statusOrder= statusOrder;
        this.noteForShipper = noteForShipper;
        this.receiverName = receiverName;
        this.receiverPhoneNum = receiverPhoneNum;
        this.idDelivery = idDelivery;
    }
    
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

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
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

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
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

 

  
}
