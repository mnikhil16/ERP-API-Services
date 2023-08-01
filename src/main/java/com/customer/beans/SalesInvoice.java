package com.customer.beans;

import jakarta.persistence.*;

import java.util.ArrayList;

/**
 * This class represents a SalesInvoice object with details like salesInvoiceId, totalAmount, salesDate, salesInvoiceNumber, supplierInvoiceNumber, companyId, supplierId, storeId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    Supplier supplier;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Store store;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    Customer customer;


    public SalesInvoice(Integer salesInvoiceId, Double totalAmount, String salesDate, String salesInvoiceNumber, Company company, Supplier supplier, Store store, Customer customer) {
        this.salesInvoiceId = salesInvoiceId;
        this.totalAmount = totalAmount;
        this.salesDate = salesDate;
        this.salesInvoiceNumber = salesInvoiceNumber;
        this.company = company;
        this.supplier = supplier;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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