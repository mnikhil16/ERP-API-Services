package com.main.entity;

import jakarta.persistence.*;

/**
 * This class represents a Company object with details like company id, company name, type, website, gst, addressId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 * Usage:
 * The Company class can be used to store and retrieve information about a company in the system.
 */
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    Integer companyId; // Unique identifier for the company entity.

    @Column(name = "company_name")
    String companyName; // Name of the company.

    @Column(name = "type")
    String type; // Type or category of the company.

    @Column(name = "website")
    String website; // Company's website URL.

    @Column(name = "gst")
    String gst; // Goods and Services Tax (GST) identification number.

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address; // Address associated with the company.

    /**
     * Constructor to initialize the Company entity with provided values.
     *
     * @param companyId    Unique identifier for the company.
     * @param companyName Name of the company.
     * @param type         Type or category of the company.
     * @param website      Company's website URL.
     * @param gst          Goods and Services Tax (GST) identification number.
     * @param address      Address associated with the company.
     */
    public Company(Integer companyId, String companyName, String type, String website, String gst, Address address) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.type = type;
        this.website = website;
        this.gst = gst;
        this.address = address;
    }

    /**
     * Default constructor required by JPA.
     */
    public Company() {
    }

    /**
     * Get the unique identifier of the company.
     *
     * @return The company identifier.
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * Set the unique identifier of the company.
     *
     * @param companyId The company identifier to set.
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * Get the name of the company.
     *
     * @return The company name.
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Set the name of the company.
     *
     * @param companyName The company name to set.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Get the type or category of the company.
     *
     * @return The company type.
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type or category of the company.
     *
     * @param type The company type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the company's website URL.
     *
     * @return The company's website.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Set the company's website URL.
     *
     * @param website The company's website to set.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Get the Goods and Services Tax (GST) identification number.
     *
     * @return The GST identification number.
     */
    public String getGst() {
        return gst;
    }

    /**
     * Set the Goods and Services Tax (GST) identification number.
     *
     * @param gst The GST identification number to set.
     */
    public void setGst(String gst) {
        this.gst = gst;
    }

    /**
     * Get the address associated with the company.
     *
     * @return The company's address.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the address associated with the company.
     *
     * @param address The company's address to set.
     */
    public void setAddress(Address address) {
        this.address = address;
    }
}