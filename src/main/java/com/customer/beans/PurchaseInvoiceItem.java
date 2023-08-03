package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a PurchaseInvoiceItem object with details like purchaseInvoiceItemId, quantity, amount, storeId, stockItemId and purchaseInvoiceId.
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Integer storeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stock_item_id")
    Integer stockItemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_invoice_id")
    Integer purchaseInvoiceId;

    public PurchaseInvoiceItem(){}
    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param purchaseInvoiceItemId    The purchaseInvoiceId of the purchase invoice.
     * @param quantity                  The date of purchase invoice.
     * @param amount                    The amount of the purchase invoice.
     * @param storeId                   The Id of the store.
     * @param stockItemId               The Id of stockItem.
     * @param purchaseInvoiceId         The Id of purchase invoice.
     */
    public PurchaseInvoiceItem(Integer purchaseInvoiceItemId, Integer quantity, Double amount, Integer storeId, Integer stockItemId, Integer purchaseInvoiceId) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.storeId = storeId;
        this.stockItemId = stockItemId;
        this.purchaseInvoiceId = purchaseInvoiceId;
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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStockItemId() {
        return stockItemId;
    }

    public void setStockItemId(Integer stockItemId) {
        this.stockItemId = stockItemId;
    }

    public Integer getPurchaseInvoiceId() {
        return purchaseInvoiceId;
    }

    public void setPurchaseInvoiceId(Integer purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
    }
}
