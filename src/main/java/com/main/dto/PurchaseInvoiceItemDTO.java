package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing an item within a purchase invoice.
 */
public class PurchaseInvoiceItemDTO {
    Integer purchaseInvoiceItemId; // Unique identifier for the purchase invoice item.
    Integer quantity; // Quantity of the item.
    Double amount; // Amount associated with the item.
    StoreDTO storeDTO; // Store details associated with the item.
    StockItemDTO stockItemDTO; // Stock item details associated with the item.
    PurchaseInvoiceDTO purchaseInvoiceDTO; // Purchase invoice details associated with the item.

    /**
     * Default constructor for the PurchaseInvoiceItemDTO class.
     */
    public PurchaseInvoiceItemDTO() {
    }

    /**
     * Parameterized constructor to create a PurchaseInvoiceItemDTO object with specified details.
     *
     * @param purchaseInvoiceItemId The unique identifier for the purchase invoice item.
     * @param quantity              The quantity of the item.
     * @param amount                The amount associated with the item.
     * @param storeDTO              The StoreDTO object containing store details.
     * @param stockItemDTO          The StockItemDTO object containing stock item details.
     * @param purchaseInvoiceDTO    The PurchaseInvoiceDTO object containing purchase invoice details.
     */
    public PurchaseInvoiceItemDTO(Integer purchaseInvoiceItemId, Integer quantity, Double amount,
                                  StoreDTO storeDTO, StockItemDTO stockItemDTO, PurchaseInvoiceDTO purchaseInvoiceDTO) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.storeDTO = storeDTO;
        this.stockItemDTO = stockItemDTO;
        this.purchaseInvoiceDTO = purchaseInvoiceDTO;
    }

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the purchase invoice item.
     *
     * @return The purchase invoice item id.
     */
    public Integer getPurchaseInvoiceItemId() {
        return purchaseInvoiceItemId;
    }

    /**
     * Set the unique identifier for the purchase invoice item.
     *
     * @param purchaseInvoiceItemId The purchase invoice item id to set.
     */
    public void setPurchaseInvoiceItemId(Integer purchaseInvoiceItemId) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
    }

    /**
     * Get the quantity of the item.
     *
     * @return The item quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the item.
     *
     * @param quantity The item quantity to set.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the amount associated with the item.
     *
     * @return The item amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Set the amount associated with the item.
     *
     * @param amount The item amount to set.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
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
     * Get the PurchaseInvoiceDTO object containing purchase invoice details.
     *
     * @return The PurchaseInvoiceDTO object.
     */
    public PurchaseInvoiceDTO getPurchaseInvoiceDTO() {
        return purchaseInvoiceDTO;
    }

    /**
     * Set the PurchaseInvoiceDTO object containing purchase invoice details.
     *
     * @param purchaseInvoiceDTO The PurchaseInvoiceDTO object to set.
     */
    public void setPurchaseInvoiceDTO(PurchaseInvoiceDTO purchaseInvoiceDTO) {
        this.purchaseInvoiceDTO = purchaseInvoiceDTO;
    }
}