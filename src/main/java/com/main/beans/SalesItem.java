package com.main.beans;

import jakarta.persistence.*;

/**
 * This class represents a SalesItem object with details like salesItemId, quantity, amount and salesInvoice.
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

    @ManyToOne
    @JoinColumn(name = "sales_invoice_id")
    SalesInvoice salesInvoice;

    @OneToOne
    @JoinColumn(name = "stock_item_id")
    StockItem stockItem;

    public SalesItem(){}

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param salesItemId  The Id of the sales items.
     * @param quantity     The quantity of the sales items.
     * @param amount       The amount of the sales items.
     * @param salesInvoice The sales invoice of the sales items.
     * @param stockItem    The stock item of the sales items.
     */
    public SalesItem(Integer salesItemId, Integer quantity, Double amount, SalesInvoice salesInvoice, StockItem stockItem) {
        this.salesItemId = salesItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.salesInvoice = salesInvoice;
        this.stockItem = stockItem;
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

    public SalesInvoice getSalesInvoice() {
        return salesInvoice;
    }

    public void setSalesInvoice(SalesInvoice salesInvoice) {
        this.salesInvoice = salesInvoice;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }
}