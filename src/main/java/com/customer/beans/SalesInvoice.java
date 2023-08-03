package com.customer.beans;

import jakarta.persistence.*;

import java.util.ArrayList;

/**
 * This class represents a SalesInvoice object with details like salesInvoiceId, totalAmount, salesDate, salesInvoiceNumber, supplierInvoiceNumber, companyId, supplierId, storeId.
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    Integer companyId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    Integer storeId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    Integer customerId;


    public SalesInvoice(){}

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param salesInvoiceId       The Id of the sales invoice.
     * @param totalAmount          Total amount of the sales invoice.
     * @param salesDate            The date of the sales invoice.
     * @param salesInvoiceNumber   The number of the sales invoice.
     * @param companyId            The companyId of the sales invoice.
     * @param storeId              The storeId of the sales invoice.
     * @param customerId           The customerId of the sales invoice.
     */
    public SalesInvoice(Integer salesInvoiceId, Double totalAmount, String salesDate, String salesInvoiceNumber, Integer companyId, Integer storeId, Integer customerId) {
        this.salesInvoiceId = salesInvoiceId;
        this.totalAmount = totalAmount;
        this.salesDate = salesDate;
        this.salesInvoiceNumber = salesInvoiceNumber;
        this.companyId = companyId;
        this.storeId = storeId;
        this.customerId = customerId;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}