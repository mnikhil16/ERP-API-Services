package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a SalesItem object with details like salesItemId, quantity, amount and salesInvoiceId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The SalesItem class can be used to store and retrieve information about a salesItems in the system.
 */
@Entity
@Table(name = "sales_items")
public class SalesItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_items_id")
    Integer salesItemId;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "amount")
    Double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sales_invoice_id")
    Integer salesInvoiceId;

    public SalesItem(){}
    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param salesItemId   The Id of the sales items.
     * @param quantity       The quantity of the sales items.
     * @param amount         The amount of the sales items.
     * @param salesInvoiceId The sales invoice id of the sales items.
     */
    public SalesItem(Integer salesItemId, Integer quantity, Double amount, Integer salesInvoiceId) {
        this.salesItemId = salesItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.salesInvoiceId = salesInvoiceId;
    }

    public Integer getSalesItemId() {
        return salesItemId;
    }

    public void setSalesItemId(Integer salesItemId) {
        this.salesItemId = salesItemId;
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

    public Integer getSalesInvoiceId() {
        return salesInvoiceId;
    }

    public void setSalesInvoiceId(Integer salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
    }
}