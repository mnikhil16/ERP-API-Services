package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing a customer entity.
 */
public class CustomerDTO {
    Integer customerId; // Unique identifier for the customer.
    String firstName; // First name of the customer.
    String lastName; // Last name of the customer.
    String displayName; // Display name of the customer.
    String dateOfBirth; // Date of birth of the customer.
    Integer age; // Age of the customer.
    String email; // Email address of the customer.
    String phoneNumber; // Phone number of the customer.
    AddressDTO addressDTO; // Address details associated with the customer.
    StoreDTO storeDTO; // Store details associated with the customer.

    /**
     * Default constructor for the CustomerDTO class.
     */
    public CustomerDTO() {
    }

    /**
     * Parameterized constructor to create a CustomerDTO object with specified details.
     *
     * @param customerId   The unique identifier for the customer.
     * @param firstName    The first name of the customer.
     * @param lastName     The last name of the customer.
     * @param displayName  The display name of the customer.
     * @param dateOfBirth  The date of birth of the customer.
     * @param age          The age of the customer.
     * @param email        The email address of the customer.
     * @param phoneNumber  The phone number of the customer.
     * @param addressDTO   The AddressDTO object containing the customer's address details.
     * @param storeDTO     The StoreDTO object containing the customer's store details.
     */
    public CustomerDTO(Integer customerId, String firstName, String lastName, String displayName, String dateOfBirth,
                       Integer age, String email, String phoneNumber, AddressDTO addressDTO, StoreDTO storeDTO) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressDTO = addressDTO;
        this.storeDTO = storeDTO;
    }

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the customer.
     *
     * @return The customer id.
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * Set the unique identifier for the customer.
     *
     * @param customerId The customer id to set.
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Get the first name of the customer.
     *
     * @return The customer's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the customer.
     *
     * @param firstName The customer's first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the customer.
     *
     * @return The customer's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the customer.
     *
     * @param lastName The customer's last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the display name of the customer.
     *
     * @return The customer's display name.
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the display name of the customer.
     *
     * @param displayName The customer's display name to set.
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the date of birth of the customer.
     *
     * @return The customer's date of birth.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the date of birth of the customer.
     *
     * @param dateOfBirth The customer's date of birth to set.
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Get the age of the customer.
     *
     * @return The customer's age.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Set the age of the customer.
     *
     * @param age The customer's age to set.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Get the email address of the customer.
     *
     * @return The customer's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the customer.
     *
     * @param email The customer's email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the customer.
     *
     * @return The customer's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of the customer.
     *
     * @param phoneNumber The customer's phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the AddressDTO object containing the customer's address details.
     *
     * @return The AddressDTO object.
     */
    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    /**
     * Set the AddressDTO object containing the customer's address details.
     *
     * @param addressDTO The AddressDTO object to set.
     */
    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    /**
     * Get the StoreDTO object containing the customer's store details.
     *
     * @return The StoreDTO object.
     */
    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    /**
     * Set the StoreDTO object containing the customer's store details.
     *
     * @param storeDTO The StoreDTO object to set.
     */
    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }
}
