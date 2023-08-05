package com.main.beans;

import jakarta.persistence.*;

/**
 * This class represents a SalesInvoice object with details like salesInvoice, totalAmount, salesDate, salesInvoiceNumber, supplierInvoiceNumber, company, supplier, store.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The SalesInvoice class can be used to store and retrieve information about a sales invoice in the system.
 */

@Entity
@Table(name = "sales_invoice")
public class SalesInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_invoice_id")
    Integer salesInvoiceId;

    @Column(name = "total_amount")
    Double totalAmount;

    @Column(name = "sales_date")
    String salesDate;

    @Column(name = "sales_invoice_no")
    String salesInvoiceNumber;

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company;

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;


    public SalesInvoice(){}

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param salesInvoiceId       The Id of the sales invoice.
     * @param totalAmount          Total amount of the sales invoice.
     * @param salesDate            The date of the sales invoice.
     * @param salesInvoiceNumber   The number of the sales invoice.
     * @param company            The company of the sales invoice.
     * @param store              The store of the sales invoice.
     * @param customer           The customer of the sales invoice.
     */
    public SalesInvoice(Integer salesInvoiceId, Double totalAmount, String salesDate, String salesInvoiceNumber, Company company, Store store, Customer customer) {
        this.salesInvoiceId = salesInvoiceId;
        this.totalAmount = totalAmount;
        this.salesDate = salesDate;
        this.salesInvoiceNumber = salesInvoiceNumber;
        this.company = company;
        this.store = store;
        this.customer = customer;
    }

    public Integer getSalesInvoiceId() {
        return salesInvoiceId;
    }

    public void setSalesInvoiceId(Integer salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getSalesDate() {
        return salesDate;
    }

    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    public String getSalesInvoiceNumber() {
        return salesInvoiceNumber;
    }

    public void setSalesInvoiceNumber(String salesInvoiceNumber) {
        this.salesInvoiceNumber = salesInvoiceNumber;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}