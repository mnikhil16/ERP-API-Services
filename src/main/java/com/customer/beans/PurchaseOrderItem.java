package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a purchase order item object with details like purchaseOrderItemId, quantity, storeId, stockItemId and purchaseOrderId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The purchase order item class can be used to store and retrieve information about a purchase order items in the system.
 */
@Entity
@Table(name = "purchase_order_items")
public class PurchaseOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_items_id")
    Integer purchaseOrderItemId;

    @Column(name = "quantity")
    Integer quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Integer storeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_item_id")
    Integer stockItemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_order_id")
    Integer purchaseOrderId;

    public PurchaseOrderItem(){}
    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param purchaseOrderItemId    The Id of the purchase order items.
     * @param quantity                The quantity of the purchase order items.
     * @param storeId                 The storeId of the purchase order items.
     * @param stockItemId             The stockItemId of the purchase order items.
     * @param purchaseOrderId         The purchaseOrderId of the purchase order items.
     */
    public PurchaseOrderItem(Integer purchaseOrderItemId, Integer quantity, Integer storeId, Integer stockItemId, Integer purchaseOrderId) {
        this.purchaseOrderItemId = purchaseOrderItemId;
        this.quantity = quantity;
        this.storeId = storeId;
        this.stockItemId = stockItemId;
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getPurchaseOrderItemId() {
        return purchaseOrderItemId;
    }

    public void setPurchaseOrderItemId(Integer purchaseOrderItemId) {
        this.purchaseOrderItemId = purchaseOrderItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Integer stockItemId) {
        this.stockItemId = stockItemId;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }
}
