package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing a supplier.
 */
public class SupplierDTO {
    Integer supplierId; // Unique identifier for the supplier.
    String firstName; // First name of the supplier.
    String lastName; // Last name of the supplier.
    String email; // Email address of the supplier.
    String phoneNumber; // Phone number of the supplier.
    StoreDTO storeDTO; // Store details associated with the supplier.
    CompanyDTO companyDTO; // Company details associated with the supplier.
    AddressDTO addressDTO; // Address details of the supplier.

    /**
     * Default constructor for the SupplierDTO class.
     */
    public SupplierDTO() {
    }

    /**
     * Parameterized constructor to create a SupplierDTO object with specified details.
     *
     * @param supplierId   The unique identifier for the supplier.
     * @param firstName    The first name of the supplier.
     * @param lastName     The last name of the supplier.
     * @param email        The email address of the supplier.
     * @param phoneNumber  The phone number of the supplier.
     * @param storeDTO     The StoreDTO object containing store details.
     * @param companyDTO   The CompanyDTO object containing company details.
     * @param addressDTO   The AddressDTO object containing address details.
     */
    public SupplierDTO(Integer supplierId, String firstName, String lastName, String email, String phoneNumber,
                       StoreDTO storeDTO, CompanyDTO companyDTO, AddressDTO addressDTO) {
        this.supplierId = supplierId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.storeDTO = storeDTO;
        this.companyDTO = companyDTO;
        this.addressDTO = addressDTO;
    }

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the supplier.
     *
     * @return The supplier id.
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * Set the unique identifier for the supplier.
     *
     * @param supplierId The supplier id to set.
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * Get the first name of the supplier.
     *
     * @return The supplier's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the supplier.
     *
     * @param firstName The supplier's first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the last name of the supplier.
     *
     * @return The supplier's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name of the supplier.
     *
     * @param lastName The supplier's last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the email address of the supplier.
     *
     * @return The supplier's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the supplier.
     *
     * @param email The supplier's email address to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the phone number of the supplier.
     *
     * @return The supplier's phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number of the supplier.
     *
     * @param phoneNumber The supplier's phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Get the StoreDTO object containing store details associated with the supplier.
     *
     * @return The StoreDTO object.
     */
    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    /**
     * Set the StoreDTO object containing store details associated with the supplier.
     *
     * @param storeDTO The StoreDTO object to set.
     */
    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }

    /**
     * Get the CompanyDTO object containing company details associated with the supplier.
     *
     * @return The CompanyDTO object.
     */
    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    /**
     * Set the CompanyDTO object containing company details associated with the supplier.
     *
     * @param companyDTO The CompanyDTO object to set.
     */
    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    /**
     * Get the AddressDTO object containing address details of the supplier.
     *
     * @return The AddressDTO object.
     */
    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    /**
     * Set the AddressDTO object containing address details of the supplier.
     *
     * @param addressDTO The AddressDTO object to set.
     */
    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}