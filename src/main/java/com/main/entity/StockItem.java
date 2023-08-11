package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a StockItem object with details like stockItemId, itemName, itemType, brandName, price, manufacturedDate, expiryDate, description, and company.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The StockItem class can be used to store and retrieve information about an item.
 */
@Entity
@Table(name = "stock_item")
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_item_id")
    Integer stockItemId; // Unique identifier for the stock item.

    @Column(name = "item_name")
    String itemName; // Name of the item.

    @Column(name = "item_type")
    String itemType; // Type of the item.

    @Column(name = "brand_name")
    String brandName; // Brand name of the item.

    @Column(name = "price")
    Double price; // Price of the item.

    @Column(name = "mfd")
    String manufacturedDate; // Manufactured date of the item.

    @Column(name = "exd")
    String expiryDate; // Expiry date of the item.

    @Column(name = "description")
    String description; // Description of the item.

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company; // Company associated with the item.

    public StockItem() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a StockItem object with specified details.
     *
     * @param stockItemId        The unique identifier of the stock item.
     * @param itemName           The name of the item.
     * @param itemType           The type of the item.
     * @param brandName          The brand name of the item.
     * @param price              The price of the item.
     * @param manufacturedDate   The manufactured date of the item.
     * @param expiryDate         The expiry date of the item.
     * @param description        The description of the item.
     * @param company            The company associated with the item.
     */
    public StockItem(Integer stockItemId, String itemName, String itemType, String brandName, Double price, String manufacturedDate, String expiryDate, String description, Company company) {
        this.stockItemId = stockItemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.brandName = brandName;
        this.price = price;
        this.manufacturedDate = manufacturedDate;
        this.expiryDate = expiryDate;
        this.description = description;
        this.company = company;
    }

    /**
     * Get the unique identifier of the stock item.
     *
     * @return The stock item's unique identifier.
     */
    public Integer getStockItemId() {
        return stockItemId;
    }

    /**
     * Set the unique identifier of the stock item.
     *
     * @param stockItemId The stock item's unique identifier to set.
     */
    public void setStockItemId(Integer stockItemId) {
        this.stockItemId = stockItemId;
    }

    /**
     * Get the name of the item.
     *
     * @return The name of the item.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set the name of the item.
     *
     * @param itemName The name of the item to set.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Get the type of the item.
     *
     * @return The type of the item.
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * Set the type of the item.
     *
     * @param itemType The type of the item to set.
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * Get the brand name of the item.
     *
     * @return The brand name of the item.
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Set the brand name of the item.
     *
     * @param brandName The brand name of the item to set.
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Get the price of the item.
     *
     * @return The price of the item.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Set the price of the item.
     *
     * @param price The price of the item to set.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Get the manufactured date of the item.
     *
     * @return The manufactured date of the item.
     */
    public String getManufacturedDate() {
        return manufacturedDate;
    }

    /**
     * Set the manufactured date of the item.
     *
     * @param manufacturedDate The manufactured date of the item to set.
     */
    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    /**
     * Get the expiry date of the item.
     *
     * @return The expiry date of the item.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Set the expiry date of the item.
     *
     * @param expiryDate The expiry date of the item to set.
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Get the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the item.
     *
     * @param description The description of the item to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the company associated with the item.
     *
     * @return The company associated with the item.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Set the company associated with the item.
     *
     * @param company The company associated with the item to set.
     */
    public void setCompany(Company company) {
        this.company = company;
    }
}