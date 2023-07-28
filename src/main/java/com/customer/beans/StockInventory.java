package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a Customer object with details like inventoryId, quantity, lastStockDate, itemId, storeId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The Customer class can be used to store and retrieve information about a customer in the system.
 */
@Entity
@Table(name = "stock_inventory")
public class StockInventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_inventory_id")
    Integer inventoryId;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "last_stock_date")
    String lastStockDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "item_id")
    Integer itemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "store_id")
    Integer storeId;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param inventoryId             The storeId of the inventory.
     * @param quantity       The quantity of items left in the inventory
     * @param lastStockDate  The date of last stock arrived in the inventory.
     * @param itemId         The storeId's of the items present in the inventory.
     * @param storeId        The storeId's of the stores that are using the inventory to store the items.
     */
    public StockInventory(Integer inventoryId, Integer quantity, String lastStockDate, Integer itemId, Integer storeId) {
        this.inventoryId = inventoryId;
        this.quantity = quantity;
        this.lastStockDate = lastStockDate;
        this.itemId = itemId;
        this.storeId = storeId;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setId(Integer inventoryId) {
        this.inventoryId = inventoryId;
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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
}
