package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a SalesItems object with details like salesItemsId, quantity, amount and salesInvoiceId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The SalesItems class can be used to store and retrieve information about a salesItems in the system.
 */
@Entity
@Table(name = "sales_items")
public class SalesItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_items_id")
    Integer salesItemsId;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "amount")
    Double amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Store store;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sales_invoice_id")
    SalesInvoice salesInvoice;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param salesItemsId   The Id of the sales items.
     * @param quantity       The quantity of the sales items.
     * @param amount         The amount of the sales items.
     * @param store        The Id of the store.
     * @param salesInvoice The sales invoice id of the sales items.
     */
    public SalesItems(Integer salesItemsId, Integer quantity, Double amount,Store store, SalesInvoice salesInvoice) {
        this.salesItemsId = salesItemsId;
        this.quantity = quantity;
        this.amount = amount;
        this.store = store;
        this.salesInvoice = salesInvoice;
    }

    public Integer getSalesItemsId() {
        return salesItemsId;
    }

    public void setSalesItemsId(Integer salesItemsId) {
        this.salesItemsId = salesItemsId;
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

    public SalesInvoice getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
    }
}