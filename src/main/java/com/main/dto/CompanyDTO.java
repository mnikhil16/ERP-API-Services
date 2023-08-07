package com.main.dto;

import jakarta.persistence.*;

public class CompanyDTO {
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
    AddressDTO addressDTO;

    public CompanyDTO(){}
    public CompanyDTO(Integer companyId, String companyName, String type, String website, String gst, AddressDTO addressDTO) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.type = type;
        this.website = website;
        this.gst = gst;
        this.addressDTO = addressDTO;
    }

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

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
