package com.customer.beans;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Integer storeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    Integer companyId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    Integer supplierId;

    public PurchaseOrder(){}
    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param purchaseOrderId   The Id of the purchase order.
     * @param totalAmount       The total amount of the purchase order.
     * @param storeId           The storeId of the purchase order.
     * @param companyId         The companyId of the purchase order.
     * @param supplierId        The supplierId of the purchase order.
     */
    public PurchaseOrder(Integer purchaseOrderId, Double totalAmount, Integer storeId, Integer companyId, Integer supplierId) {
        this.purchaseOrderId = purchaseOrderId;
        this.totalAmount = totalAmount;
        this.storeId = storeId;
        this.companyId = companyId;
        this.supplierId = supplierId;
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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
}
