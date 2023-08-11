package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a SalesItem object with details like salesItemId, quantity, amount and salesInvoice.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The SalesItem class can be used to store and retrieve information about sales items in the system.
 */
@Entity
@Table(name = "sales_items")
public class SalesItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_items_id")
    Integer salesItemId; // Unique identifier for the sales item entity.

    @Column(name = "quantity")
    Integer quantity; // Quantity of the sales item.

    @Column(name = "amount")
    Double amount; // Amount associated with the sales item.

    @ManyToOne
    @JoinColumn(name = "sales_invoice_id")
    SalesInvoice salesInvoice; // Sales invoice associated with the sales item.

    @OneToOne
    @JoinColumn(name = "stock_item_id")
    StockItem stockItem; // Stock item associated with the sales item.

    public SalesItem() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a SalesItem object with specified details.
     *
     * @param salesItemId   The Id of the sales items.
     * @param quantity      The quantity of the sales items.
     * @param amount        The amount of the sales items.
     * @param salesInvoice  The sales invoice of the sales items.
     * @param stockItem     The stock item of the sales items.
     */
    public SalesItem(Integer salesItemId, Integer quantity, Double amount, SalesInvoice salesInvoice, StockItem stockItem) {
        this.salesItemId = salesItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.salesInvoice = salesInvoice;
        this.stockItem = stockItem;
    }

    /**
     * Get the unique identifier of the sales item.
     *
     * @return The sales item identifier.
     */
    public Integer getSalesItemId() {
        return salesItemId;
    }

    /**
     * Set the unique identifier of the sales item.
     *
     * @param salesItemId The sales item identifier to set.
     */
    public void setSalesItemId(Integer salesItemId) {
        this.salesItemId = salesItemId;
    }

    /**
     * Get the quantity of the sales item.
     *
     * @return The quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the sales item.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the amount associated with the sales item.
     *
     * @return The amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Set the amount associated with the sales item.
     *
     * @param amount The amount to set.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Get the sales invoice associated with the sales item.
     *
     * @return The sales invoice.
     */
    public SalesInvoice getSalesInvoice() {
        return salesInvoice;
    }

    /**
     * Set the sales invoice associated with the sales item.
     *
     * @param salesInvoice The sales invoice to set.
     */
    public void setSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
    }

    /**
     * Get the stock item associated with the sales item.
     *
     * @return The stock item.
     */
    public StockItem getStockItem() {
        return stockItem;
    }

    /**
     * Set the stock item associated with the sales item.
     *
     * @param stockItem The stock item to set.
     */
    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }
}
