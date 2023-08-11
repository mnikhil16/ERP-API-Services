package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a StockInventory object with details like stockInventoryId, quantity, lastStockDate, stockItem, store, and supplier.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The StockInventory class can be used to store and retrieve information about stock inventory in the system.
 */
@Entity
@Table(name = "stock_inventory")
public class StockInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_inventory_id")
    Integer stockInventoryId; // Unique identifier for the stock inventory entity.

    @Column(name = "quantity")
    Integer quantity; // Quantity of items left in the inventory.

    @Column(name = "last_stock_date")
    String lastStockDate; // Date of the last stock arrived in the inventory.

    @OneToOne
    @JoinColumn(name = "stock_item_id")
    StockItem stockItem; // Stock item present in the inventory.

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store; // Store associated with the inventory.

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier; // Supplier associated with the inventory.

    public StockInventory() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a StockInventory object with specified details.
     *
     * @param stockInventoryId   The unique identifier of the stock inventory.
     * @param quantity           The quantity of items left in the inventory.
     * @param lastStockDate      The date of the last stock arrived in the inventory.
     * @param stockItem          The stock item present in the inventory.
     * @param store              The store associated with the inventory.
     * @param supplier           The supplier associated with the inventory.
     */
    public StockInventory(Integer stockInventoryId, Integer quantity, String lastStockDate, StockItem stockItem, Store store, Supplier supplier) {
        this.stockInventoryId = stockInventoryId;
        this.quantity = quantity;
        this.lastStockDate = lastStockDate;
        this.stockItem = stockItem;
        this.store = store;
        this.supplier = supplier;
    }

    /**
     * Gets the unique identifier of the stock inventory.
     *
     * @return The stock inventory identifier.
     */
    public Integer getStockInventoryId() {
        return stockInventoryId;
    }

    /**
     * Sets the unique identifier of the stock inventory.
     *
     * @param stockInventoryId The new stock inventory identifier.
     */
    public void setStockInventoryId(Integer stockInventoryId) {
        this.stockInventoryId = stockInventoryId;
    }

    /**
     * Gets the quantity of items left in the inventory.
     *
     * @return The quantity of items in the inventory.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of items in the inventory.
     *
     * @param quantity The new quantity of items in the inventory.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the date of the last stock arrival in the inventory.
     *
     * @return The date of the last stock arrival.
     */
    public String getLastStockDate() {
        return lastStockDate;
    }

    /**
     * Sets the date of the last stock arrival in the inventory.
     *
     * @param lastStockDate The new date of the last stock arrival.
     */
    public void setLastStockDate(String lastStockDate) {
        this.lastStockDate = lastStockDate;
    }

    /**
     * Gets the stock item present in the inventory.
     *
     * @return The stock item in the inventory.
     */
    public StockItem getStockItem() {
        return stockItem;
    }

    /**
     * Sets the stock item present in the inventory.
     *
     * @param stockItem The new stock item in the inventory.
     */
    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    /**
     * Gets the store associated with the inventory.
     *
     * @return The store associated with the inventory.
     */
    public Store getStore() {
        return store;
    }

    /**
     * Sets the store associated with the inventory.
     *
     * @param store The new store associated with the inventory.
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Gets the supplier associated with the inventory.
     *
     * @return The supplier associated with the inventory.
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Sets the supplier associated with the inventory.
     *
     * @param supplier The new supplier associated with the inventory.
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}