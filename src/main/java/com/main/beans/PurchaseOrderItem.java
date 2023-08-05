package com.main.beans;

import jakarta.persistence.*;

/**
 * This class represents a purchase order item object with details like purchaseOrderItemId, quantity, store, stockItem and purchaseOrderId.
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

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;

    @ManyToOne
    @JoinColumn(name = "stock_item_id")
    StockItem stockItem;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    PurchaseOrder purchaseOrder;

    public PurchaseOrderItem(){}
    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param purchaseOrderItemId    The Id of the purchase order items.
     * @param quantity                The quantity of the purchase order items.
     * @param store                 The store of the purchase order items.
     * @param stockItem             The stockItem of the purchase order items.
     * @param purchaseOrder         The purchaseOrderId of the purchase order items.
     */
    public PurchaseOrderItem(Integer purchaseOrderItemId, Integer quantity, Store store, StockItem stockItem, PurchaseOrder purchaseOrder) {
        this.purchaseOrderItemId = purchaseOrderItemId;
        this.quantity = quantity;
        this.store = store;
        this.stockItem = stockItem;
        this.purchaseOrder = purchaseOrder;
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

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}
