package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing a sales invoice entity.
 */
public class SalesInvoiceDTO {
    Integer salesInvoiceId; // Unique identifier for the sales invoice.
    Double totalAmount; // Total amount of the sales invoice.
    String salesDate; // Date of the sales.
    String salesInvoiceNumber; // Sales invoice number.
    CompanyDTO companyDTO; // Company details associated with the sales invoice.
    StoreDTO storeDTO; // Store details associated with the sales invoice.
    CustomerDTO customerDTO; // Customer details associated with the sales invoice.

    /**
     * Default constructor for the SalesInvoiceDTO class.
     */
    public SalesInvoiceDTO() {
    }

    /**
     * Parameterized constructor to create a SalesInvoiceDTO object with specified details.
     *
     * @param salesInvoiceId     The unique identifier for the sales invoice.
     * @param totalAmount        The total amount of the sales invoice.
     * @param salesDate          The date of the sales.
     * @param salesInvoiceNumber The sales invoice number.
     * @param companyDTO         The CompanyDTO object containing company details.
     * @param storeDTO           The StoreDTO object containing store details.
     * @param customerDTO        The CustomerDTO object containing customer details.
     */
    public SalesInvoiceDTO(Integer salesInvoiceId, Double totalAmount, String salesDate, String salesInvoiceNumber,
                           CompanyDTO companyDTO, StoreDTO storeDTO, CustomerDTO customerDTO) {
        this.salesInvoiceId = salesInvoiceId;
        this.totalAmount = totalAmount;
        this.salesDate = salesDate;
        this.salesInvoiceNumber = salesInvoiceNumber;
        this.companyDTO = companyDTO;
        this.storeDTO = storeDTO;
        this.customerDTO = customerDTO;
    }

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the sales invoice.
     *
     * @return The sales invoice id.
     */
    public Integer getSalesInvoiceId() {
        return salesInvoiceId;
    }

    /**
     * Set the unique identifier for the sales invoice.
     *
     * @param salesInvoiceId The sales invoice id to set.
     */
    public void setSalesInvoiceId(Integer salesInvoiceId) {
        this.salesInvoiceId = salesInvoiceId;
    }

    /**
     * Get the total amount of the sales invoice.
     *
     * @return The sales invoice total amount.
     */
    public Double getTotalAmount() {
        return totalAmount;
    }

    /**
     * Set the total amount of the sales invoice.
     *
     * @param totalAmount The sales invoice total amount to set.
     */
    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * Get the date of the sales.
     *
     * @return The sales date.
     */
    public String getSalesDate() {
        return salesDate;
    }

    /**
     * Set the date of the sales.
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
     * Get the StoreDTO object containing store details.
     *
     * @return The StoreDTO object.
     */
    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    /**
     * Set the StoreDTO object containing store details.
     *
     * @param storeDTO The StoreDTO object to set.
     */
    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }

    /**
     * Get the CustomerDTO object containing customer details.
     *
     * @return The CustomerDTO object.
     */
    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    /**
     * Set the CustomerDTO object containing customer details.
     *
     * @param customerDTO The CustomerDTO object to set.
     */
    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
}