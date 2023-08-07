package com.main.dto;

import jakarta.persistence.*;

public class PurchaseInvoiceDTO {
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

    @ManyToOne
    @JoinColumn(name = "company_id")
    CompanyDTO companyDTO;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    SupplierDTO supplierDTO;

    public PurchaseInvoiceDTO(){}

    public PurchaseInvoiceDTO(Integer purchaseInvoiceId, Double amount, String purchaseDate, String purchaseInvoiceNo, String supplierInvoiceNo, CompanyDTO companyDTO, SupplierDTO supplierDTO) {
        this.purchaseInvoiceId = purchaseInvoiceId;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.purchaseInvoiceNo = purchaseInvoiceNo;
        this.supplierInvoiceNo = supplierInvoiceNo;
        this.companyDTO = companyDTO;
        this.supplierDTO = supplierDTO;
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

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }
}
