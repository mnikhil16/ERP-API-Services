package com.main.dto;

public class AddressDTO {
    Integer addressId;
    String dno;
    String street;
    String city;
    String state;
    Integer pinCode;

    public AddressDTO() {
    }

    /**
     * Parameterized constructor to create an Address object with specified details.
     * @param addressId  The address id of the address
     * @param dno       The door number.
     * @param street     The street address.
     * @param city       The city name.
     * @param state      The state name.
     * @param pinCode    The pin code or ZIP code.
     */
    public AddressDTO(Integer addressId, String dno, String street, String city, String state, Integer pinCode) {
        this.addressId = addressId;
        this.dno = dno;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getDNo() {
        return dno;
    }

    public void setDNo(String dno) {
        this.dno = dno;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}
