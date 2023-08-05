package com.main.beans;

import jakarta.persistence.*;

/**
 * This class represents a PurchaseInvoiceItem object with details like purchaseInvoiceItemId, quantity, amount, store, stockItem and purchaseInvoice.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The PurchaseInvoiceItem class can be used to store and retrieve information about a purchase invoice items in the system.
 */
@Entity
@Table(name = "purchase_invoice_item")
public class PurchaseInvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_invoice_items_id")
    Integer purchaseInvoiceItemId;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "amount")
    Double amount;

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;

    @ManyToOne
    @JoinColumn(name = "stock_item_id")
    StockItem stockItem;

    @ManyToOne
    @JoinColumn(name = "purchase_invoice_id")
    PurchaseInvoice purchaseInvoice;

    public PurchaseInvoiceItem(){}
    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param purchaseInvoiceItemId     The purchaseInvoice of the purchase invoice.
     * @param quantity                  The date of purchase invoice.
     * @param amount                    The amount of the purchase invoice.
     * @param store                     The Id of the store.
     * @param stockItem               The Id of stockItem.
     * @param purchaseInvoice           The Id of purchase invoice.
     */
    public PurchaseInvoiceItem(Integer purchaseInvoiceItemId, Integer quantity, Double amount, Store store, StockItem stockItem, PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.store = store;
        this.stockItem = stockItem;
        this.purchaseInvoice = purchaseInvoice;
    }

    public Integer getPurchaseInvoiceItemId() {
        return purchaseInvoiceItemId;
    }

    public void setPurchaseInvoiceItemId(Integer purchaseInvoiceItemId) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    public PurchaseInvoice getPurchaseInvoice() {
        return purchaseInvoice;
    }

    public void setPurchaseInvoice(PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoice = purchaseInvoice;
    }
}
