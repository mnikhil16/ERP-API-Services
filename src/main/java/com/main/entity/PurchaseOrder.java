package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a PurchaseOrder object with details like purchaseOrderId, totalAmount, store , company, supplier.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The PurchaseOrder class can be used to store and retrieve information about a purchaseOrder in the system.
 */
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_id")
    Integer purchaseOrderId; // Unique identifier for the purchase order entity.

    @Column(name = "total_amount")
    Double totalAmount; // Total amount of the purchase order.

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store; // Store associated with the purchase order.

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company; // Company associated with the purchase order.

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier; // Supplier associated with the purchase order.

    public PurchaseOrder() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a PurchaseOrder object with specified details.
     *
     * @param purchaseOrderId The Id of the purchase order.
     * @param totalAmount     The total amount of the purchase order.
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

    /**
     * Get the unique identifier of the purchase order.
     *
     * @return The purchase order identifier.
     */
    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    /**
     * Set the unique identifier of the purchase order.
     *
     * @param purchaseOrderId The purchase order identifier to set.
     */
    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    /**
     * Get the total amount of the purchase order.
     *
     * @return The total amount.
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Set the total amount of the purchase order.
     *
     * @param totalAmount The total amount to set.
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Get the store associated with the purchase order.
     *
     * @return The store.
     */
    public Store getStore() {
        return store;
    }

    /**
     * Set the store associated with the purchase order.
     *
     * @param store The store to set.
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Get the company associated with the purchase order.
     *
     * @return The company.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Set the company associated with the purchase order.
     *
     * @param company The company to set.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Get the supplier associated with the purchase order.
     *
     * @return The supplier.
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Set the supplier associated with the purchase order.
     *
     * @param supplier The supplier to set.
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}