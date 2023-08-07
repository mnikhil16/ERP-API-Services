package com.main.beans;

import jakarta.persistence.*;

/**
 * This class represents an StockItem object with details like itemId, itemName, itemType, brandName, price, manufactured date, expiry date, description about product and company of the item.
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
    Integer stockItemId;

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

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    public StockItem(){}
    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param stockItemId          The store of an item.
     * @param itemName             The name of an item.
     * @param itemType             The type of item.
     * @param brandName            The brand of an item.
     * @param price                The price of an item.
     * @param manufacturedDate     The manufactured date of an item.
     * @param expiryDate           The expiryDate of an item.
     * @param description          The description of an item.
     * @param company            The Id of a company.
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

    public Integer getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Integer stockItemId) {
        this.stockItemId = stockItemId;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
