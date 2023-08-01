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
    StockItem stockItem;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Store store;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    Supplier supplier;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param stockInventoryId    The storeId of the inventory.
     * @param quantity       The quantity of items left in the inventory
     * @param lastStockDate  The date of last stock arrived in the inventory.
     * @param stockItem        The storeId's of the items present in the inventory.
     * @param store        The Id of the store.
     * @param company      The Id of the company.
     * @param supplier     The Id of the supplier.
     */
    public StockInventory(Integer stockInventoryId, Integer quantity, String lastStockDate, StockItem stockItem, Store store, Company company, Supplier supplier) {
        this.stockInventoryId = stockInventoryId;
        this.quantity = quantity;
        this.lastStockDate = lastStockDate;
        this.stockItem = stockItem;
        this.store = store;
        this.company = company;
        this.supplier = supplier;
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

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
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