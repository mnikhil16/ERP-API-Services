package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a PurchaseInvoice object with details like purchaseInvoice, amount, purchase date, purchase invoice number, supplier invoice number, company and supplier.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The PurchaseInvoice class can be used to store and retrieve information about a purchase invoice in the system.
 */
@Entity
@Table(name = "purchase_invoice")
public class PurchaseInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_invoice_id")
    Integer purchaseInvoiceId; // Unique identifier for the purchase invoice entity.

    @Column(name = "amount")
    Double amount; // Amount of the purchase invoice.

    @Column(name = "purchase_date")
    String purchaseDate; // Date of the purchase invoice.

    @Column(name = "purchase_invoice_no")
    String purchaseInvoiceNo; // Purchase invoice number.

    @Column(name = "supplier_invoice_no")
    String supplierInvoiceNo; // Supplier invoice number.

    @ManyToOne
    @JoinColumn(name = "company_id")
    Company company; // Company associated with the purchase invoice.

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    Supplier supplier; // Supplier associated with the purchase invoice.

    public PurchaseInvoice() {
        // Default constructor required by JPA.
    }

    /**
     * Parameterized constructor to create a PurchaseInvoice object with specified details.
     *
     * @param purchaseInvoiceId  The purchaseInvoice of the purchase invoice.
     * @param amount             The amount of the purchase invoice.
     * @param purchaseDate       The date of purchase invoice.
     * @param purchaseInvoiceNo  The number of the purchase invoice.
     * @param supplierInvoiceNo  The number of the supplier invoice.
     * @param company            The company of the purchase invoice.
     * @param supplier           The supplier of the purchase invoice.
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

    /**
     * Get the unique identifier of the purchase invoice.
     *
     * @return The purchase invoice identifier.
     */
    public Integer getPurchaseInvoiceId() {
        return purchaseInvoiceId;
    }

    /**
     * Set the unique identifier of the purchase invoice.
     *
     * @param purchaseInvoiceId The purchase invoice identifier to set.
     */
    public void setPurchaseInvoiceId(Integer purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
    }

    /**
     * Get the amount of the purchase invoice.
     *
     * @return The amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Set the amount of the purchase invoice.
     *
     * @param amount The amount to set.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Get the date of the purchase invoice.
     *
     * @return The purchase date.
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Set the date of the purchase invoice.
     *
     * @param purchaseDate The purchase date to set.
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * Get the purchase invoice number.
     *
     * @return The purchase invoice number.
     */
    public String getPurchaseInvoiceNo() {
        return purchaseInvoiceNo;
    }

    /**
     * Set the purchase invoice number.
     *
     * @param purchaseInvoiceNo The purchase invoice number to set.
     */
    public void setPurchaseInvoiceNo(String purchaseInvoiceNo) {
        this.purchaseInvoiceNo = purchaseInvoiceNo;
    }

    /**
     * Get the supplier invoice number.
     *
     * @return The supplier invoice number.
     */
    public String getSupplierInvoiceNo() {
        return supplierInvoiceNo;
    }

    /**
     * Set the supplier invoice number.
     *
     * @param supplierInvoiceNo The supplier invoice number to set.
     */
    public void setSupplierInvoiceNo(String supplierInvoiceNo) {
        this.supplierInvoiceNo = supplierInvoiceNo;
    }

    /**
     * Get the company associated with the purchase invoice.
     *
     * @return The company.
     */
    public Company getCompany() {
        return company;
    }

    /**
     * Set the company associated with the purchase invoice.
     *
     * @param company The company to set.
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Get the supplier associated with the purchase invoice.
     *
     * @return The supplier.
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Set the supplier associated with the purchase invoice.
     *
     * @param supplier The supplier to set.
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}