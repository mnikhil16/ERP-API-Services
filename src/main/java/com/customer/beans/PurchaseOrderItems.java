package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a purchase order items object with details like purchaseOrderItemsId, quantity, storeId, stockItemId and purchaseOrderId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The purchase order items class can be used to store and retrieve information about a purchase order items in the system.
 */
@Entity
@Table(name = "purchase_order_items")
public class PurchaseOrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_items_id")
    Integer purchaseOrderItemsId;

    @Column(name = "quantity")
    Integer quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Store store;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_item_id")
    StockItem stockItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_order_id")
    PurchaseOrder purchaseOrder;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param purchaseOrderItemsId    The Id of the purchase order items.
     * @param quantity                The quantity of the purchase order items.
     * @param store                 The storeId of the purchase order items.
     * @param stockItem             The stockItemId of the purchase order items.
     * @param purchaseOrder         The purchaseOrderId of the purchase order items.
     */
    public PurchaseOrderItems(Integer purchaseOrderItemsId, Integer quantity, Store store, StockItem stockItem, PurchaseOrder purchaseOrder) {
        this.purchaseOrderItemsId = purchaseOrderItemsId;
        this.quantity = quantity;
        this.store = store;
        this.stockItem = stockItem;
        this.purchaseOrder = purchaseOrder;
    }

    public Integer getPurchaseOrderItemsId() {
        return purchaseOrderItemsId;
    }

    public void setPurchaseOrderItemsId(Integer purchaseOrderItemsId) {
        this.purchaseOrderItemsId = purchaseOrderItemsId;
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
