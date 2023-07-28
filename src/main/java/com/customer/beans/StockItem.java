package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents an StockItem object with details like itemId, itemName, itemType, brandName, price, manufactured date, expiry date, description about product and companyId of the item.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The StockItem class can be used to store and retrieve information about an item.
 */
@Entity
@Table(name = "item")
public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stock_item_id")
    Integer itemId;

    @Column(name = "item_name")
    String itemName;

    @Column(name = "item_type")
    String itemType;

    @Column(name = "brand_name")
    String brandName;

    @Column(name = "price")
    Double price;

    @Column(name = "mfd")
    String manufacturedDate;

    @Column(name = "exd")
    String expiryDate;

    @Column(name = "description")
    String description;

    @Column(name = "company_id")
    Integer companyId;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param itemId               The storeId of an item.
     * @param itemName             The name of an item.
     * @param itemType             The type of item.
     * @param brandName           The brand of an item.
     * @param price            The price of an item.
     * @param manufacturedDate The manufactured date of an item.
     * @param expiryDate       The expiryDate of an item.
     * @param description      The description of an item.
     * @param companyId       The quantity of items left.
     */
    public StockItem(Integer itemId, String itemName, String itemType, String brandName, Double price, String manufacturedDate, String expiryDate, String description, Integer companyId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.brandName = brandName;
        this.price = price;
        this.manufacturedDate = manufacturedDate;
        this.expiryDate = expiryDate;
        this.description = description;
        this.companyId = companyId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }
}
