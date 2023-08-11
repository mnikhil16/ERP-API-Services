package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing an item within a sales invoice.
 */
public class SalesItemDTO {
    Integer salesItemId; // Unique identifier for the sales item.
    Integer quantity; // Quantity of the item.
    Double amount; // Amount associated with the item.
    SalesInvoiceDTO salesInvoiceDTO; // Sales invoice details associated with the item.
    StockItemDTO stockItemDTO; // Stock item details associated with the item.

    /**
     * Default constructor for the SalesItemDTO class.
     */
    public SalesItemDTO() {
    }

    /**
     * Parameterized constructor to create a SalesItemDTO object with specified details.
     *
     * @param salesItemId     The unique identifier for the sales item.
     * @param quantity        The quantity of the item.
     * @param amount          The amount associated with the item.
     * @param salesInvoiceDTO The SalesInvoiceDTO object containing sales invoice details.
     * @param stockItemDTO    The StockItemDTO object containing stock item details.
     */
    public SalesItemDTO(Integer salesItemId, Integer quantity, Double amount,
                        SalesInvoiceDTO salesInvoiceDTO, StockItemDTO stockItemDTO) {
        this.salesItemId = salesItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.salesInvoiceDTO = salesInvoiceDTO;
        this.stockItemDTO = stockItemDTO;
    }

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the sales item.
     *
     * @return The sales item id.
     */
    public Integer getSalesItemId() {
        return salesItemId;
    }

    /**
     * Set the unique identifier for the sales item.
     *
     * @param salesItemId The sales item id to set.
     */
    public void setSalesItemId(Integer salesItemId) {
        this.salesItemId = salesItemId;
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
     * Get the SalesInvoiceDTO object containing sales invoice details.
     *
     * @return The SalesInvoiceDTO object.
     */
    public SalesInvoiceDTO getSalesInvoiceDTO() {
        return salesInvoiceDTO;
    }

    /**
     * Set the SalesInvoiceDTO object containing sales invoice details.
     *
     * @param salesInvoiceDTO The SalesInvoiceDTO object to set.
     */
    public void setSalesInvoiceDTO(SalesInvoiceDTO salesInvoiceDTO) {
        this.salesInvoiceDTO = salesInvoiceDTO;
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
}