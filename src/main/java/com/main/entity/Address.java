package com.main.entity;

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
    Integer addressId; // Unique identifier for the address entity.

    @Column(name = "d_no")
    String dno; // Door number or unit number of the address.

    @Column(name = "street")
    String street; // Name of the street or road.

    @Column(name = "city")
    String city; // Name of the city or locality.

    @Column(name = "state")
    String state; // State or province of the address.

    @Column(name = "pin_code")
    Integer pinCode; // Postal code or ZIP code of the address.

    public Address() {
        // Default constructor required by JPA.
    }

    /**
     * Constructor to initialize the Address entity with provided values.
     *
     * @param addressId Unique identifier for the address.
     * @param dno       Door number or unit number of the address.
     * @param street    Name of the street or road.
     * @param city      Name of the city or locality.
     * @param state     State or province of the address.
     * @param pinCode   Postal code or ZIP code of the address.
     */
    public Address(Integer addressId, String dno, String street, String city, String state, Integer pinCode) {
        this.addressId = addressId;
        this.dno = dno;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    /**
     * Get the unique identifier of the address.
     *
     * @return The address identifier.
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * Set the unique identifier of the address.
     *
     * @param addressId The address identifier to set.
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * Get the door number or unit number of the address.
     *
     * @return The door number or unit number.
     */
    public String getDNo() {
        return dno;
    }

    /**
     * Set the door number or unit number of the address.
     *
     * @param dno The door number or unit number to set.
     */
    public void setDNo(String dno) {
        this.dno = dno;
    }

    /**
     * Get the name of the street or road.
     *
     * @return The street name.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the name of the street or road.
     *
     * @param street The street name to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the name of the city or locality.
     *
     * @return The city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the name of the city or locality.
     *
     * @param city The city name to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the state or province of the address.
     *
     * @return The state or province.
     */
    public String getState() {
        return state;
    }

    /**
     * Set the state or province of the address.
     *
     * @param state The state or province to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the postal code or ZIP code of the address.
     *
     * @return The postal code or ZIP code.
     */
    public Integer getPinCode() {
        return pinCode;
    }

    /**
     * Set the postal code or ZIP code of the address.
     *
     * @param pinCode The postal code or ZIP code to set.
     */
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}