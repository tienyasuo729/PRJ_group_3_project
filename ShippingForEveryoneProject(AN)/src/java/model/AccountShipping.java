package model;

public class AccountShipping {
    private String nameAccount;
    private Account account;
    private TypeVehicle typeVehicle;
    private Size size;
    private int maximumStorageVolume;
    private String licensePlate;
    private Address currentPosition;
    private TransportImage transportImage;

    public AccountShipping() {
    }

    public AccountShipping(String nameAccount, Account account, TypeVehicle typeVehicle, Size size, int maximumStorageVolume, String licensePlate, Address currentPosition, TransportImage transportImage) {
        this.nameAccount = nameAccount;
        this.account = account;
        this.typeVehicle = typeVehicle;
        this.size = size;
        this.maximumStorageVolume = maximumStorageVolume;
        this.licensePlate = licensePlate;
        this.currentPosition = currentPosition;
        this.transportImage = transportImage;
    }

    public AccountShipping(Account account) {
        this.account = account;       
    }

    public AccountShipping(String nameAccount, Account account) {
        this.nameAccount = nameAccount;
        this.account = account;
    }

    
    
    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public TypeVehicle getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(TypeVehicle typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getMaximumStorageVolume() {
        return maximumStorageVolume;
    }

    public void setMaximumStorageVolume(int maximumStorageVolume) {
        this.maximumStorageVolume = maximumStorageVolume;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Address getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Address currentPosition) {
        this.currentPosition = currentPosition;
    }

    public TransportImage getTransportImage() {
        return transportImage;
    }

    public void setTransportImage(TransportImage transportImage) {
        this.transportImage = transportImage;
    }
}
