package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a purchase order item object with details like purchaseOrderItemId, quantity, store, stockItem and purchaseOrderId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The purchase order item class can be used to store and retrieve information about purchase order items in the system.
 */
@Entity
@Table(name = "purchase_order_items")
public class PurchaseOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_items_id")
    Integer purchaseOrderItemId; // Unique identifier for the purchase order item entity.

    @Column(name = "quantity")
    Integer quantity; // Quantity of the purchase order item.

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store; // Store associated with the purchase order item.

    @OneToOne
    @JoinColumn(name = "stock_item_id")
    StockItem stockItem; // Stock item associated with the purchase order item.

    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    PurchaseOrder purchaseOrder; // Purchase order associated with the purchase order item.

    public PurchaseOrderItem() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a PurchaseOrderItem object with specified details.
     *
     * @param purchaseOrderItemId The Id of the purchase order item.
     * @param quantity            The quantity of the purchase order item.
     * @param store               The store associated with the purchase order item.
     * @param stockItem           The stock item associated with the purchase order item.
     * @param purchaseOrder       The purchase order associated with the purchase order item.
     */
    public PurchaseOrderItem(Integer purchaseOrderItemId, Integer quantity, Store store, StockItem stockItem, PurchaseOrder purchaseOrder) {
        this.purchaseOrderItemId = purchaseOrderItemId;
        this.quantity = quantity;
        this.store = store;
        this.stockItem = stockItem;
        this.purchaseOrder = purchaseOrder;
    }

    /**
     * Get the unique identifier of the purchase order item.
     *
     * @return The purchase order item identifier.
     */
    public Integer getPurchaseOrderItemId() {
        return purchaseOrderItemId;
    }

    /**
     * Set the unique identifier of the purchase order item.
     *
     * @param purchaseOrderItemId The purchase order item identifier to set.
     */
    public void setPurchaseOrderItemId(Integer purchaseOrderItemId) {
        this.purchaseOrderItemId = purchaseOrderItemId;
    }

    /**
     * Get the quantity of the purchase order item.
     *
     * @return The quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the purchase order item.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the store associated with the purchase order item.
     *
     * @return The store.
     */
    public Store getStore() {
        return store;
    }

    /**
     * Set the store associated with the purchase order item.
     *
     * @param store The store to set.
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Get the stock item associated with the purchase order item.
     *
     * @return The stock item.
     */
    public StockItem getStockItem() {
        return stockItem;
    }

    /**
     * Set the stock item associated with the purchase order item.
     *
     * @param stockItem The stock item to set.
     */
    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    /**
     * Get the purchase order associated with the purchase order item.
     *
     * @return The purchase order.
     */
    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    /**
     * Set the purchase order associated with the purchase order item.
     *
     * @param purchaseOrder The purchase order to set.
     */
    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
}