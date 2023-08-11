package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing a purchase invoice entity.
 */
public class PurchaseInvoiceDTO {
    Integer purchaseInvoiceId; // Unique identifier for the purchase invoice.
    Double amount; // Amount of the purchase invoice.
    String purchaseDate; // Date of the purchase.
    String purchaseInvoiceNo; // Purchase invoice number.
    String supplierInvoiceNo; // Supplier invoice number.
    CompanyDTO companyDTO; // Company details associated with the purchase invoice.
    SupplierDTO supplierDTO; // Supplier details associated with the purchase invoice.

    /**
     * Default constructor for the PurchaseInvoiceDTO class.
     */
    public PurchaseInvoiceDTO() {
    }

    /**
     * Parameterized constructor to create a PurchaseInvoiceDTO object with specified details.
     *
     * @param purchaseInvoiceId The unique identifier for the purchase invoice.
     * @param amount            The amount of the purchase invoice.
     * @param purchaseDate      The date of the purchase.
     * @param purchaseInvoiceNo The purchase invoice number.
     * @param supplierInvoiceNo The supplier invoice number.
     * @param companyDTO        The CompanyDTO object containing company details.
     * @param supplierDTO       The SupplierDTO object containing supplier details.
     */
    public PurchaseInvoiceDTO(Integer purchaseInvoiceId, Double amount, String purchaseDate, String purchaseInvoiceNo,
                              String supplierInvoiceNo, CompanyDTO companyDTO, SupplierDTO supplierDTO) {
        this.purchaseInvoiceId = purchaseInvoiceId;
        this.amount = amount;
        this.purchaseDate = purchaseDate;
        this.purchaseInvoiceNo = purchaseInvoiceNo;
        this.supplierInvoiceNo = supplierInvoiceNo;
        this.companyDTO = companyDTO;
        this.supplierDTO = supplierDTO;
    }

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the purchase invoice.
     *
     * @return The purchase invoice id.
     */
    public Integer getPurchaseInvoiceId() {
        return purchaseInvoiceId;
    }

    /**
     * Set the unique identifier for the purchase invoice.
     *
     * @param purchaseInvoiceId The purchase invoice id to set.
     */
    public void setPurchaseInvoiceId(Integer purchaseInvoiceId) {
        this.purchaseInvoiceId = purchaseInvoiceId;
    }

    /**
     * Get the amount of the purchase invoice.
     *
     * @return The purchase invoice amount.
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Set the amount of the purchase invoice.
     *
     * @param amount The purchase invoice amount to set.
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Get the date of the purchase.
     *
     * @return The purchase date.
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * Set the date of the purchase.
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
     * Get the CompanyDTO object containing company details.
     *
     * @return The CompanyDTO object.
     */
    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    /**
     * Set the CompanyDTO object containing company details.
     *
     * @param companyDTO The CompanyDTO object to set.
     */
    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    /**
     * Get the SupplierDTO object containing supplier details.
     *
     * @return The SupplierDTO object.
     */
    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    /**
     * Set the SupplierDTO object containing supplier details.
     *
     * @param supplierDTO The SupplierDTO object to set.
     */
    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }
}