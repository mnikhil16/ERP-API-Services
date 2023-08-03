package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a Customer object with details like inventoryId, quantity, lastStockDate, itemId, storeId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The Customer class can be used to store and retrieve information about a customer in the system.
 */
@Entity
@Table(name = "stock_inventory")
public class StockInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_inventory_id")
    Integer stockInventoryId;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "last_stock_date")
    String lastStockDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_item_id")
    Integer stockItemId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Integer storeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    Integer supplierId;

    public StockInventory(){}
    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param stockInventoryId   The storeId of the inventory.
     * @param quantity           The quantity of items left in the inventory
     * @param lastStockDate      The date of last stock arrived in the inventory.
     * @param stockItemId        The storeId's of the items present in the inventory.
     * @param storeId            The Id of the store.
     * @param supplierId         The Id of the supplier.
     */
    public StockInventory(Integer stockInventoryId, Integer quantity, String lastStockDate, Integer stockItemId, Integer storeId, Integer supplierId) {
        this.stockInventoryId = stockInventoryId;
        this.quantity = quantity;
        this.lastStockDate = lastStockDate;
        this.stockItemId = stockItemId;
        this.storeId = storeId;
        this.supplierId = supplierId;
    }

    public Integer getStockInventoryId() {
        return stockInventoryId;
    }

    public void setStockInventoryId(Integer stockInventoryId) {
        this.stockInventoryId = stockInventoryId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getLastStockDate() {
        return lastStockDate;
    }

    public void setLastStockDate(String lastStockDate) {
        this.lastStockDate = lastStockDate;
    }

    public Integer getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Integer stockItemId) {
        this.stockItemId = stockItemId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }
}