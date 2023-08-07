package com.main.dto;

import jakarta.persistence.*;

public class SalesInvoiceDTO {
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
    CompanyDTO companyDTO;

    @ManyToOne
    @JoinColumn(name = "store_id")
    StoreDTO storeDTO;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    CustomerDTO customerDTO;

    public SalesInvoiceDTO(){}

    public SalesInvoiceDTO(Integer salesInvoiceId, Double totalAmount, String salesDate, String salesInvoiceNumber, CompanyDTO companyDTO, StoreDTO storeDTO, CustomerDTO customerDTO) {
        this.salesInvoiceId = salesInvoiceId;
        this.totalAmount = totalAmount;
        this.salesDate = salesDate;
        this.salesInvoiceNumber = salesInvoiceNumber;
        this.companyDTO = companyDTO;
        this.storeDTO = storeDTO;
        this.customerDTO = customerDTO;
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

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }
}
