package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a PurchaseInvoiceItem object with details like purchaseInvoiceItemId, quantity, amount, store, stockItem and purchaseInvoice.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The PurchaseInvoiceItem class can be used to store and retrieve information about purchase invoice items in the system.
 */
@Entity
@Table(name = "purchase_invoice_items")
public class PurchaseInvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_invoice_items_id")
    Integer purchaseInvoiceItemId; // Unique identifier for the purchase invoice item entity.

    @Column(name = "quantity")
    Integer quantity; // Quantity of the purchased items.

    @Column(name = "amount")
    Double amount; // Amount of the purchase invoice item.

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store; // Store associated with the purchase invoice item.

    @ManyToOne
    @JoinColumn(name = "stock_item_id")
    StockItem stockItem; // Stock item associated with the purchase invoice item.

    @ManyToOne
    @JoinColumn(name = "purchase_invoice_id")
    PurchaseInvoice purchaseInvoice; // Purchase invoice associated with the purchase invoice item.

    public PurchaseInvoiceItem() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a PurchaseInvoiceItem object with specified details.
     *
     * @param purchaseInvoiceItemId The purchaseInvoiceItemId of the purchase invoice item.
     * @param quantity              The quantity of the purchase invoice item.
     * @param amount                The amount of the purchase invoice item.
     * @param store                 The store associated with the purchase invoice item.
     * @param stockItem             The stock item associated with the purchase invoice item.
     * @param purchaseInvoice       The purchase invoice associated with the purchase invoice item.
     */
    public PurchaseInvoiceItem(Integer purchaseInvoiceItemId, Integer quantity, Double amount, Store store, StockItem stockItem, PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.store = store;
        this.stockItem = stockItem;
        this.purchaseInvoice = purchaseInvoice;
    }

    /**
     * Get the unique identifier of the purchase invoice item.
     *
     * @return The purchase invoice item identifier.
     */
    public Integer getPurchaseInvoiceItemId() {
        return purchaseInvoiceItemId;
    }

    /**
     * Set the unique identifier of the purchase invoice item.
     *
     * @param purchaseInvoiceItemId The purchase invoice item identifier to set.
     */
    public void setPurchaseInvoiceItemId(Integer purchaseInvoiceItemId) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
    }

    /**
     * Get the quantity of the purchase invoice item.
     *
     * @return The quantity.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the purchase invoice item.
     *
     * @param quantity The quantity to set.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the amount of the purchase invoice item.
     *
     * @return The amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Set the amount of the purchase invoice item.
     *
     * @param amount The amount to set.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Get the store associated with the purchase invoice item.
     *
     * @return The store.
     */
    public Store getStore() {
        return store;
    }

    /**
     * Set the store associated with the purchase invoice item.
     *
     * @param store The store to set.
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Get the stock item associated with the purchase invoice item.
     *
     * @return The stock item.
     */
    public StockItem getStockItem() {
        return stockItem;
    }

    /**
     * Set the stock item associated with the purchase invoice item.
     *
     * @param stockItem The stock item to set.
     */
    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    /**
     * Get the purchase invoice associated with the purchase invoice item.
     *
     * @return The purchase invoice.
     */
    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    /**
     * Set the purchase invoice associated with the purchase invoice item.
     *
     * @param purchaseInvoice The purchase invoice to set.
     */
    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }
}
