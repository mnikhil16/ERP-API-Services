package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing a stock inventory entry.
 */
public class StockInventoryDTO {
    Integer stockInventoryId; // Unique identifier for the stock inventory entry.
    Integer quantity; // Quantity of stock items.
    String lastStockDate; // Date of the last stock update.
    StockItemDTO stockItemDTO; // Stock item details associated with the inventory entry.
    StoreDTO storeDTO; // Store details associated with the inventory entry.
    SupplierDTO supplierDTO; // Supplier details associated with the inventory entry.

    /**
     * Default constructor for the StockInventoryDTO class.
     */
    public StockInventoryDTO() {
    }

    /**
     * Parameterized constructor to create a StockInventoryDTO object with specified details.
     *
     * @param stockInventoryId The unique identifier for the stock inventory entry.
     * @param quantity         The quantity of stock items.
     * @param lastStockDate    The date of the last stock update.
     * @param stockItemDTO     The StockItemDTO object containing stock item details.
     * @param storeDTO         The StoreDTO object containing store details.
     * @param supplierDTO      The SupplierDTO object containing supplier details.
     */
    public StockInventoryDTO(Integer stockInventoryId, Integer quantity, String lastStockDate,
                             StockItemDTO stockItemDTO, StoreDTO storeDTO, SupplierDTO supplierDTO) {
        this.stockInventoryId = stockInventoryId;
        this.quantity = quantity;
        this.lastStockDate = lastStockDate;
        this.stockItemDTO = stockItemDTO;
        this.storeDTO = storeDTO;
        this.supplierDTO = supplierDTO;
    }

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the stock inventory entry.
     *
     * @return The stock inventory id.
     */
    public Integer getStockInventoryId() {
        return stockInventoryId;
    }

    /**
     * Set the unique identifier for the stock inventory entry.
     *
     * @param stockInventoryId The stock inventory id to set.
     */
    public void setStockInventoryId(Integer stockInventoryId) {
        this.stockInventoryId = stockInventoryId;
    }

    /**
     * Get the quantity of stock items.
     *
     * @return The quantity of stock items.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of stock items.
     *
     * @param quantity The quantity of stock items to set.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the date of the last stock update.
     *
     * @return The last stock update date.
     */
    public String getLastStockDate() {
        return lastStockDate;
    }

    /**
     * Set the date of the last stock update.
     *
     * @param lastStockDate The last stock update date to set.
     */
    public void setLastStockDate(String lastStockDate) {
        this.lastStockDate = lastStockDate;
    }

    /**
     * Get the StockItemDTO object containing stock item details.
     *
     * @return The StockItemDTO object.
     */
    public StockItemDTO getStockItemDTO() {
        return stockItemDTO;
    }

    /**
     * Set the StockItemDTO object containing stock item details.
     *
     * @param stockItemDTO The StockItemDTO object to set.
     */
    public void setStockItemDTO(StockItemDTO stockItemDTO) {
        this.stockItemDTO = stockItemDTO;
    }

    /**
     * Get the StoreDTO object containing store details.
     *
     * @return The StoreDTO object.
     */
    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    /**
     * Set the StoreDTO object containing store details.
     *
     * @param storeDTO The StoreDTO object to set.
     */
    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }

    /**
     * Get the SupplierDTO object containing supplier details.
     *
     * @return The SupplierDTO object.
     */
    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    /**
     * Set the SupplierDTO object containing supplier details.
     *
     * @param supplierDTO The SupplierDTO object to set.
     */
    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }
}