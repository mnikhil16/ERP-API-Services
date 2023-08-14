package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing an address.
 */
public class AddressDTO {
    Integer addressId; // Unique identifier for the address.
    String dno; // Door number of the address.
    String street; // Street address.
    String city; // City name.
    String state; // State name.
    Integer pinCode; // Pin code or ZIP code of the area.

    /**
     * Default constructor for the AddressDTO class.
     */
    public AddressDTO() {
    }

    /**
     * Parameterized constructor to create an AddressDTO object with specified details.
     *
     * @param addressId The unique identifier for the address.
     * @param dno       The door number.
     * @param street    The street address.
     * @param city      The city name.
     * @param state     The state name.
     * @param pinCode   The pin code or ZIP code.
     */
    public AddressDTO(Integer addressId, String dno, String street, String city, String state, Integer pinCode) {
        this.addressId = addressId;
        this.dno = dno;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    /**
     * Get the unique identifier for the address.
     *
     * @return The address id.
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * Set the unique identifier for the address.
     *
     * @param addressId The address id to set.
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * Get the door number of the address.
     *
     * @return The door number.
     */
    public String getDNo() {
        return dno;
    }

    /**
     * Set the door number of the address.
     *
     * @param dno The door number to set.
     */
    public void setDNo(String dno) {
        this.dno = dno;
    }

    /**
     * Get the street address.
     *
     * @return The street address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the street address.
     *
     * @param street The street address to set.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the city name.
     *
     * @return The city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city name.
     *
     * @param city The city name to set.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the state name.
     *
     * @return The state name.
     */
    public String getState() {
        return state;
    }

    /**
     * Set the state name.
     *
     * @param state The state name to set.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the pin code or ZIP code.
     *
     * @return The pin code.
     */
    public Integer getPinCode() {
        return pinCode;
    }

    /**
     * Set the pin code or ZIP code.
     *
     * @param pinCode The pin code to set.
     */
    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }
}