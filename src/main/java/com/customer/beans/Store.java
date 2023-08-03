package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a Store object with details like storeId, storeName, branch, companyId, address.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The Store class can be used to store and retrieve information about a store in the system.
 */
@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    Integer storeId;

    @Column(name = "storeName")
    String storeName;

    @Column(name = "branch")
    String branch;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    Integer companyId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    Address address;

    public Store(){};

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param storeId       The storeId of the store.
     * @param storeName     The name of the store.
     * @param branch        The branch of the store.
     * @param companyId     The storeId of the customer who purchases items in the store.
     * @param address       The Address object representing the store's address.
     */
    public Store(Integer storeId, String storeName, String branch, Integer companyId, Address address) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.branch = branch;
        this.companyId = companyId;
        this.address = address;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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
