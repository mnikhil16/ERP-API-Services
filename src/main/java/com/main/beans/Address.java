package com.main.beans;

import jakarta.persistence.*;

/**
 * This class represents an Address object with details such as addressId, D_no, street, city, state and pin code.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The Address class can be used to store and retrieve address information of a customer or any entity.
 * It is commonly used as a property of the Customer class to represent a customer's address.
 * It is commonly used as a property of the Store class to represent a store's address.
 * It is commonly used as a property of the StockInventory class to represent a stockInventory's address.
 * It is commonly used as a property of the Supplier class to represent a supplier's address.
 */
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    Integer addressId;
    @Column(name = "d_no")
    String dno;
    @Column(name = "street")
    String street;
    @Column(name = "city")
    String city;
    @Column(name = "state")
    String state;
    @Column(name = "pin_code")
    Integer pinCode;



    public Address() {
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
    public Address(Integer addressId, String dno, String street, String city, String state, Integer pinCode) {
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