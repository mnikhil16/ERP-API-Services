package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a Store object with details like storeId, storeName, branch, company Id, address Id.
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

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "company_id")
    Integer companyId;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "address_id")
    Integer addressId;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param storeId            The storeId of the store.
     * @param storeName        The name of the store.
     * @param branch        The branch of the store.
     * @param companyId    The storeId of the customer who purchases items in the store.
     * @param addressId     The address of the store.
     */
    public Store(Integer storeId, String storeName, String branch, Integer companyId, Integer addressId) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.branch = branch;
        this.companyId = companyId;
        this.addressId = addressId;
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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
}
