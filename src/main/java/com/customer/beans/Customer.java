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

    public Customer() {
    }

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param customerId    The storeId of the customer.
     * @param firstName     The first name of the customer.
     * @param lastName      The last name of the customer.
     * @param displayName   The display name of the customer.
     * @param dateOfBirth   The date of birth of the customer.
     * @param age           The age of the customer.
     * @param email         The email of the customer.
     * @param phoneNumber   The phone number of the customer.
     * @param address       The Address object representing the customer's address.
     */
    public Customer(Integer customerId, String firstName, String lastName, String displayName, String dateOfBirth, Integer age, String email, String phoneNumber, Address address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Get the storeId of the customer.
     *
     * @return The customer's storeId as an int.
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Set the storeId of the customer.
     *
     * @param customerId The storeId of the customer to set.
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Get the first name of the customer.
     *
     * @return The customer's first name as a String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the customer.
     *
     * @param firstName The first name of the customer to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the customer.
     *
     * @return The customer's last name as a String.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the customer.
     *
     * @param lastName The last name of the customer to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the display name of the customer.
     *
     * @return The customer's display name as a String.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the display name of the customer.
     *
     * @param displayName The display name of the customer to set.
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the date of birth of the customer.
     *
     * @return The customer's date of birth as a String.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the date of birth of the customer.
     *
     * @param dateOfBirth The date of birth of the customer to set.
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get the age of the customer.
     *
     * @return The customer's age as an int.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Set the age of the customer.
     *
     * @param age The age of the customer to set.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Get the email of the customer.
     *
     * @return The customer's email as a String.
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the customer.
     *
     * @return The customer's phone number as a String.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the Address object representing the customer's address.
     *
     * @return The Address object representing the customer's address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the Address object representing the customer's address.
     *
     * @param address The Address object representing the customer's address to set.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}
