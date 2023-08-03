package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a Customer object with details like storeId, first_name, last_name, display_name, dob, age, email, phone number and address.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The Customer class can be used to store and retrieve information about a customer in the system.
 */
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    Integer supplierId;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Integer storeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    Integer companyId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;

    public Supplier(){}

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param supplierId    The Id of the supplier.
     * @param firstName     The first name of the supplier.
     * @param lastName      The last name of the supplier.
     * @param email         The email of the supplier.
     * @param phoneNumber   The phoneNumber of the supplier.
     * @param storeId       The Id of the store.
     * @param companyId     The Id of the company.
     * @param address       The Address object representing the customer's address.
     */
    public Supplier(Integer supplierId, String firstName, String lastName, String email, String phoneNumber, Integer storeId, Integer companyId, Address address) {
        this.supplierId = supplierId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.storeId = storeId;
        this.companyId = companyId;
        this.address = address;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
