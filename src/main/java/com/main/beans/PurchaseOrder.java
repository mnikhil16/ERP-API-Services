package com.main.beans;

import jakarta.persistence.*;

/**
 * This class represents a PurchaseOrder object with details like purchaseOrderId, totalAmount, store , company, supplier.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The PurchaseOrder class can be used to store and retrieve information about a purchaseOrder in the system.
 */

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_id")
    Integer purchaseOrderId;

    @Column(name = "total_amount")
    Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;

    @OneToOne
    @JoinColumn(name = "company_id")
    Company company;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    Supplier supplier;

    public PurchaseOrder(){}
    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param purchaseOrderId   The Id of the purchase order.
     * @param totalAmount       The total amount of the purchase order.
     * @param store           The store of the purchase order.
     * @param company         The company of the purchase order.
     * @param supplier        The supplier of the purchase order.
     */
    public PurchaseOrder(Integer purchaseOrderId, Double totalAmount, Store store, Company company, Supplier supplier) {
        this.purchaseOrderId = purchaseOrderId;
        this.totalAmount = totalAmount;
        this.store = store;
        this.company = company;
        this.supplier = supplier;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
