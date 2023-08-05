package com.main.beans;

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
    Integer customerId;
    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "display_name")
    String displayName;

    @Column(name = "dob")
    String dateOfBirth;

    @Column(name = "age")
    Integer age;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;

    public Customer() {
    }

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param customerId    The Id of the customer.
     * @param firstName     The first name of the customer.
     * @param lastName      The last name of the customer.
     * @param displayName   The display name of the customer.
     * @param dateOfBirth   The date of birth of the customer.
     * @param age           The age of the customer.
     * @param email         The email of the customer.
     * @param phoneNumber   The phone number of the customer.
     * @param address       The Address object representing the customer's address.
     * @param store       The store of the customer.
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
