package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a Supplier object with details like supplierId, firstName, lastName, email, phoneNumber, store, company, and address.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The Supplier class can be used to store and retrieve information about a supplier in the system.
 */
@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    Integer supplierId; // Unique identifier for the supplier.

    @Column(name = "first_name")
    String firstName; // First name of the supplier.

    @Column(name = "last_name")
    String lastName; // Last name of the supplier.

    @Column(name = "email")
    String email; // Email address of the supplier.

    @Column(name = "phone_number")
    String phoneNumber; // Phone number of the supplier.

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store; // Store associated with the supplier.

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company; // Company associated with the supplier.

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address; // Address of the supplier.

    public Supplier() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a Supplier object with specified details.
     *
     * @param supplierId   The unique identifier of the supplier.
     * @param firstName    The first name of the supplier.
     * @param lastName     The last name of the supplier.
     * @param email        The email of the supplier.
     * @param phoneNumber  The phone number of the supplier.
     * @param store        The store associated with the supplier.
     * @param company      The company associated with the supplier.
     * @param address      The Address object representing the supplier's address.
     */
    public Supplier(Integer supplierId, String firstName, String lastName, String email, String phoneNumber, Store store, Company company, Address address) {
        this.supplierId = supplierId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.store = store;
        this.company = company;
        this.address = address;
    }

    /**
     * Get the unique identifier of the supplier.
     *
     * @return The supplier's unique identifier.
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * Set the unique identifier of the supplier.
     *
     * @param supplierId The supplier's unique identifier to set.
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * Get the first name of the supplier.
     *
     * @return The first name of the supplier.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the supplier.
     *
     * @param firstName The first name of the supplier to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the supplier.
     *
     * @return The last name of the supplier.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the supplier.
     *
     * @param lastName The last name of the supplier to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the email address of the supplier.
     *
     * @return The email address of the supplier.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the supplier.
     *
     * @param email The email address of the supplier to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the supplier.
     *
     * @return The phone number of the supplier.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of the supplier.
     *
     * @param phoneNumber The phone number of the supplier to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the store associated with the supplier.
     *
     * @return The store associated with the supplier.
     */
    public Store getStore() {
        return store;
    }

    /**
     * Set the store associated with the supplier.
     *
     * @param store The store associated with the supplier to set.
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Get the company associated with the supplier.
     *
     * @return The company associated with the supplier.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Set the company associated with the supplier.
     *
     * @param company The company associated with the supplier to set.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Get the address of the supplier.
     *
     * @return The Address object representing the supplier's address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the address of the supplier.
     *
     * @param address The Address object representing the supplier's address to set.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}