package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing a store.
 */
public class StoreDTO {
    Integer storeId; // Unique identifier for the store.
    String storeName; // Name of the store.
    String branch; // Branch name of the store.
    CompanyDTO companyDTO; // Company details associated with the store.
    AddressDTO addressDTO; // Address details of the store.

    /**
     * Parameterized constructor to create a StoreDTO object with specified details.
     *
     * @param storeId     The unique identifier for the store.
     * @param storeName   The name of the store.
     * @param branch      The branch name of the store.
     * @param companyDTO  The CompanyDTO object containing company details.
     * @param addressDTO  The AddressDTO object containing address details.
     */
    public StoreDTO(Integer storeId, String storeName, String branch, CompanyDTO companyDTO, AddressDTO addressDTO) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.branch = branch;
        this.companyDTO = companyDTO;
        this.addressDTO = addressDTO;
    }

    /**
     * Default constructor for the StoreDTO class.
     */
    public StoreDTO() {
    }

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the store.
     *
     * @return The store id.
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * Set the unique identifier for the store.
     *
     * @param storeId The store id to set.
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * Get the name of the store.
     *
     * @return The store name.
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Set the name of the store.
     *
     * @param storeName The store name to set.
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Get the branch name of the store.
     *
     * @return The store's branch name.
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Set the branch name of the store.
     *
     * @param branch The store's branch name to set.
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Get the CompanyDTO object containing company details associated with the store.
     *
     * @return The CompanyDTO object.
     */
    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    /**
     * Set the CompanyDTO object containing company details associated with the store.
     *
     * @param companyDTO The CompanyDTO object to set.
     */
    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    /**
     * Get the AddressDTO object containing address details of the store.
     *
     * @return The AddressDTO object.
     */
    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    /**
     * Set the AddressDTO object containing address details of the store.
     *
     * @param addressDTO The AddressDTO object to set.
     */
    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}