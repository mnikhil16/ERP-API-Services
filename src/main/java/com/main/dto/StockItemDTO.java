package com.main.dto;

import com.main.beans.Company;
import jakarta.persistence.*;

public class StockItemDTO {
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
    CompanyDTO companyDTO;

    public StockItemDTO(){}

    public StockItemDTO(Integer stockItemId, String itemName, String itemType, String brandName, Double price, String manufacturedDate, String expiryDate, String description, CompanyDTO companyDTO) {
        this.stockItemId = stockItemId;
        this.itemName = itemName;
        this.itemType = itemType;
        this.brandName = brandName;
        this.price = price;
        this.manufacturedDate = manufacturedDate;
        this.expiryDate = expiryDate;
        this.description = description;
        this.companyDTO = companyDTO;
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

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }
}
