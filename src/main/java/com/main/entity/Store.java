package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a Store object with details like storeId, storeName, branch, company, address.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The Store class can be used to store and retrieve information about a store in the system.
 */
@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    Integer storeId; // Unique identifier for the store.

    @Column(name = "storeName")
    String storeName; // Name of the store.

    @Column(name = "branch")
    String branch; // Branch of the store.

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company; // Company associated with the store.

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    Address address; // Address of the store.

    public Store() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a Store object with specified details.
     *
     * @param storeId   The unique identifier of the store.
     * @param storeName The name of the store.
     * @param branch    The branch of the store.
     * @param company   The company associated with the store.
     * @param address   The Address object representing the store's address.
     */
    public Store(Integer storeId, String storeName, String branch, Company company, Address address) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.branch = branch;
        this.company = company;
        this.address = address;
    }

    /**
     * Get the unique identifier of the store.
     *
     * @return The store's unique identifier.
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * Set the unique identifier of the store.
     *
     * @param storeId The store's unique identifier to set.
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * Get the name of the store.
     *
     * @return The name of the store.
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * Set the name of the store.
     *
     * @param storeName The name of the store to set.
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Get the branch of the store.
     *
     * @return The branch of the store.
     */
    public String getBranch() {
        return branch;
    }

    /**
     * Set the branch of the store.
     *
     * @param branch The branch of the store to set.
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * Get the company associated with the store.
     *
     * @return The company associated with the store.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Set the company associated with the store.
     *
     * @param company The company associated with the store to set.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Get the address of the store.
     *
     * @return The Address object representing the store's address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the address of the store.
     *
     * @param address The Address object representing the store's address to set.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}