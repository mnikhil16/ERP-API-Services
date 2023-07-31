package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a PurchaseInvoice object with details like purchaseInvoiceId, amount, purchase date, purchase invoice number, supplier invoice number, companyId and supplierId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The PurchaseInvoice class can be used to store and retrieve information about a purchase invoice in the system.
 */
@Entity
@Table(name = "purchase_invoice")
public class PurchaseInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_invoice_id")
    Integer purchaseInvoiceId;

    @Column(name = "amount")
    Double amount;

    @Column(name = "purchase_date")
    String purchaseDate;

    @Column(name = "purchase_invoice_no")
    String purchaseInvoiceNo;

    @Column(name = "supplier_invoice_no")
    String supplierInvoiceNo;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "company_id")
    Company company;

    @OneToOne(cascade = CascadeType.ALL)
    @Column(name = "supplier_id")
    Supplier supplier;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param purchaseInvoiceId    The purchaseInvoiceId of the purchase invoice.
     * @param amount               The amount of the purchase invoice.
     * @param purchaseDate         The date of purchase invoice.
     * @param purchaseInvoiceNo    The number of purchase invoice.
     * @param supplierInvoiceNo    The number of supplier invoice.
     * @param company            The companyId of purchase invoice.
     * @param supplier          The supplierId of the purchase invoice.
     */
    public PurchaseInvoice(Integer purchaseInvoiceId, Double amount, String purchaseDate, String purchaseInvoiceNo, String supplierInvoiceNo, Company company, Supplier supplier) {
        this.purchaseInvoiceId = purchaseInvoiceId;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.purchaseInvoiceNo = purchaseInvoiceNo;
        this.supplierInvoiceNo = supplierInvoiceNo;
        this.company = company;
        this.supplier = supplier;
    }

    public Integer getPurchaseInvoiceId() {
        return purchaseInvoiceId;
    }

    public void setPurchaseInvoiceId(Integer purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseInvoiceNo() {
        return purchaseInvoiceNo;
    }

    public void setPurchaseInvoiceNo(String purchaseInvoiceNo) {
        this.purchaseInvoiceNo = purchaseInvoiceNo;
    }

    public String getSupplierInvoiceNo() {
        return supplierInvoiceNo;
    }

    public void setSupplierInvoiceNo(String supplierInvoiceNo) {
        this.supplierInvoiceNo = supplierInvoiceNo;
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
}
