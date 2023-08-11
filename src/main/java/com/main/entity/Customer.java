package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a Customer object with details like customer, first_name, last_name, display_name, dob, age, email, phone number, company, store and address.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The Customer class can be used to store and retrieve information about a customer in the system.
 */
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    Integer customerId; // Unique identifier for the customer entity.

    @Column(name = "first_name")
    String firstName; // First name of the customer.

    @Column(name = "last_name")
    String lastName; // Last name of the customer.

    @Column(name = "display_name")
    String displayName; // Display name of the customer.

    @Column(name = "dob")
    String dateOfBirth; // Date of birth of the customer.

    @Column(name = "age")
    Integer age; // Age of the customer.

    @Column(name = "email")
    String email; // Email of the customer.

    @Column(name = "phone_number")
    String phoneNumber; // Phone number of the customer.

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address; // Address associated with the customer.

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store; // Store associated with the customer.

    public Customer() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param customerId  The Id of the customer.
     * @param firstName   The first name of the customer.
     * @param lastName    The last name of the customer.
     * @param displayName The display name of the customer.
     * @param dateOfBirth The date of birth of the customer.
     * @param age         The age of the customer.
     * @param email       The email of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param store       The store of the customer.
     * @param address     The Address object representing the customer's address.
     */
    public Customer(Integer customerId, String firstName, String lastName, String displayName, String dateOfBirth, Integer age, String email, String phoneNumber, Store store, Address address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.store = store;
        this.address = address;
    }

    /**
     * Get the unique identifier of the customer.
     *
     * @return The customer identifier.
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Set the unique identifier of the customer.
     *
     * @param customerId The customer identifier to set.
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Get the first name of the customer.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the customer.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the customer.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the customer.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the display name of the customer.
     *
     * @return The display name.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the display name of the customer.
     *
     * @param displayName The display name to set.
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the date of birth of the customer.
     *
     * @return The date of birth.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the date of birth of the customer.
     *
     * @param dateOfBirth The date of birth to set.
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get the age of the customer.
     *
     * @return The age.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Set the age of the customer.
     *
     * @param age The age to set.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Get the email of the customer.
     *
     * @return The email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the customer.
     *
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the customer.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of the customer.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the store associated with the customer.
     *
     * @return The store.
     */
    public Store getStore() {
        return store;
    }

    /**
     * Set the store associated with the customer.
     *
     * @param store The store to set.
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Get the address associated with the customer.
     *
     * @return The customer's address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the address associated with the customer.
     *
     * @param address The customer's address to set.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
