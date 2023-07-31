package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a PurchaseInvoiceItems object with details like purchaseInvoiceItemsId, quantity, amount, storeId, stockItemId and purchaseInvoiceId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The PurchaseInvoiceItems class can be used to store and retrieve information about a purchase invoice items in the system.
 */
@Entity
@Table(name = "purchase_invoice_items")
public class PurchaseInvoiceItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_invoice_items_id")
    Integer purchaseInvoiceItemsId;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "amount")
    Double amount;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "store_id")
    Store store;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "stock_item_id")
    StockItem stockItem;

    @ManyToOne(cascade = CascadeType.ALL)
    @Column(name = "purchase_invoice_id")
    PurchaseInvoice purchaseInvoice;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param purchaseInvoiceItemsId    The purchaseInvoiceId of the purchase invoice.
     * @param quantity                  The date of purchase invoice.
     * @param amount                    The amount of the purchase invoice.
     * @param store                   The Id of the store.
     * @param stockItem               The Id of stockItem.
     * @param purchaseInvoice         The Id of purchase invoice.
     */
    public PurchaseInvoiceItems(Integer purchaseInvoiceItemsId, Integer quantity, Double amount, Store store, StockItem stockItem, PurchaseInvoice purchaseInvoice) {
        this.purchaseInvoiceItemsId = purchaseInvoiceItemsId;
        this.quantity = quantity;
        this.amount = amount;
        this.store = store;
        this.stockItem = stockItem;
        this.purchaseInvoice = purchaseInvoice;
    }

    public Integer getPurchaseInvoiceItemsId() {
        return purchaseInvoiceItemsId;
    }

    public void setPurchaseInvoiceItemsId(Integer purchaseInvoiceItemsId) {
        this.purchaseInvoiceItemsId = purchaseInvoiceItemsId;
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
