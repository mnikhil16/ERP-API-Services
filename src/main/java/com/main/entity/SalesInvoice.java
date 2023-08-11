package com.main.entity;

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
    Integer salesInvoiceId; // Unique identifier for the sales invoice entity.

    @Column(name = "total_amount")
    Double totalAmount; // Total amount of the sales invoice.

    @Column(name = "sales_date")
    String salesDate; // Date of the sales invoice.

    @Column(name = "sales_invoice_no")
    String salesInvoiceNumber; // Number of the sales invoice.

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company; // Company associated with the sales invoice.

    @ManyToOne
    @JoinColumn(name = "store_id")
    Store store; // Store associated with the sales invoice.

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer; // Customer associated with the sales invoice.

    public SalesInvoice() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a SalesInvoice object with specified details.
     *
     * @param salesInvoiceId       The Id of the sales invoice.
     * @param totalAmount          Total amount of the sales invoice.
     * @param salesDate            The date of the sales invoice.
     * @param salesInvoiceNumber   The number of the sales invoice.
     * @param company              The company of the sales invoice.
     * @param store                The store of the sales invoice.
     * @param customer             The customer of the sales invoice.
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

    /**
     * Get the unique identifier of the sales invoice.
     *
     * @return The sales invoice identifier.
     */
    public Integer getSalesInvoiceId() {
        return salesInvoiceId;
    }

    /**
     * Set the unique identifier of the sales invoice.
     *
     * @param salesInvoiceId The sales invoice identifier to set.
     */
    public void setSalesInvoiceId(Integer salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
    }

    /**
     * Get the total amount of the sales invoice.
     *
     * @return The total amount.
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Set the total amount of the sales invoice.
     *
     * @param totalAmount The total amount to set.
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Get the date of the sales invoice.
     *
     * @return The sales date.
     */
    public String getSalesDate() {
        return salesDate;
    }

    /**
     * Set the date of the sales invoice.
     *
     * @param salesDate The sales date to set.
     */
    public void setSalesDate(String salesDate) {
        this.salesDate = salesDate;
    }

    /**
     * Get the sales invoice number.
     *
     * @return The sales invoice number.
     */
    public String getSalesInvoiceNumber() {
        return salesInvoiceNumber;
    }

    /**
     * Set the sales invoice number.
     *
     * @param salesInvoiceNumber The sales invoice number to set.
     */
    public void setSalesInvoiceNumber(String salesInvoiceNumber) {
        this.salesInvoiceNumber = salesInvoiceNumber;
    }

    /**
     * Get the company associated with the sales invoice.
     *
     * @return The company.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Set the company associated with the sales invoice.
     *
     * @param company The company to set.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Get the store associated with the sales invoice.
     *
     * @return The store.
     */
    public Store getStore() {
        return store;
    }

    /**
     * Set the store associated with the sales invoice.
     *
     * @param store The store to set.
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * Get the customer associated with the sales invoice.
     *
     * @return The customer.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Set the customer associated with the sales invoice.
     *
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}