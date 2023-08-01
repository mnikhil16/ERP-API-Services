package com.customer.beans;

import jakarta.persistence.*;

/**
 * This class represents a Company object with details like company id, company name, type, website, gst, addressId.
 * It is a Java bean class with getters, setters, and a parameterized constructor for easy data access.
 *
 * Usage:
 * The Company class can be used to store and retrieve information about a company in the system.
 */
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    Integer companyId;

    @Column(name = "company_name")
    String companyName;

    @Column(name = "type")
    String type;

    @Column(name = "website")
    String website;

    @Column(name = "gst")
    String  gst;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    Address address;

    /**
     * Parameterized constructor to create a Customer object with specified details.
     *
     * @param companyId     The Id of the company.
     * @param companyName   The name of the company.
     * @param type          The type of the company.
     * @param website       The website of the company.
     * @param gst           The gst of the company.
     * @param address       The Address object representing the customer's address.
     */
    public Company(Integer companyId, String companyName, String type, String website, String gst, Address address) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.type = type;
        this.website = website;
        this.gst = gst;
        this.address = address;
    }

    public Company(){}

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
