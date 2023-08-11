package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing a stock item.
 */
public class StockItemDTO {
    Integer stockItemId; // Unique identifier for the stock item.
    String itemName; // Name of the stock item.
    String itemType; // Type/category of the stock item.
    String brandName; // Brand name of the stock item.
    Double price; // Price of the stock item.
    String manufacturedDate; // Date when the stock item was manufactured.
    String expiryDate; // Expiry date of the stock item.
    String description; // Description of the stock item.
    CompanyDTO companyDTO; // Company details associated with the stock item.

    /**
     * Default constructor for the StockItemDTO class.
     */
    public StockItemDTO() {
    }

    /**
     * Parameterized constructor to create a StockItemDTO object with specified details.
     *
     * @param stockItemId      The unique identifier for the stock item.
     * @param itemName         The name of the stock item.
     * @param itemType         The type/category of the stock item.
     * @param brandName        The brand name of the stock item.
     * @param price            The price of the stock item.
     * @param manufacturedDate The date when the stock item was manufactured.
     * @param expiryDate       The expiry date of the stock item.
     * @param description      The description of the stock item.
     * @param companyDTO       The CompanyDTO object containing company details.
     */
    public StockItemDTO(Integer stockItemId, String itemName, String itemType, String brandName, Double price,
                        String manufacturedDate, String expiryDate, String description, CompanyDTO companyDTO) {
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

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the stock item.
     *
     * @return The stock item id.
     */
    public Integer getStockItemId() {
        return stockItemId;
    }

    /**
     * Set the unique identifier for the stock item.
     *
     * @param stockItemId The stock item id to set.
     */
    public void setStockItemId(Integer stockItemId) {
        this.stockItemId = stockItemId;
    }

    /**
     * Get the name of the stock item.
     *
     * @return The stock item name.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set the name of the stock item.
     *
     * @param itemName The stock item name to set.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Get the type/category of the stock item.
     *
     * @return The stock item type/category.
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * Set the type/category of the stock item.
     *
     * @param itemType The stock item type/category to set.
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     * Get the brand name of the stock item.
     *
     * @return The stock item brand name.
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Set the brand name of the stock item.
     *
     * @param brandName The stock item brand name to set.
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Get the price of the stock item.
     *
     * @return The stock item price.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Set the price of the stock item.
     *
     * @param price The stock item price to set.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Get the date when the stock item was manufactured.
     *
     * @return The manufactured date of the stock item.
     */
    public String getManufacturedDate() {
        return manufacturedDate;
    }

    /**
     * Set the date when the stock item was manufactured.
     *
     * @param manufacturedDate The manufactured date of the stock item to set.
     */
    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    /**
     * Get the expiry date of the stock item.
     *
     * @return The stock item expiry date.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Set the expiry date of the stock item.
     *
     * @param expiryDate The stock item expiry date to set.
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Get the description of the stock item.
     *
     * @return The stock item description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the stock item.
     *
     * @param description The stock item description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the CompanyDTO object containing company details.
     *
     * @return The CompanyDTO object.
     */
    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    /**
     * Set the CompanyDTO object containing company details.
     *
     * @param companyDTO The CompanyDTO object to set.
     */
    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }
}