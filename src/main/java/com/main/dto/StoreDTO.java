package com.main.dto;


import jakarta.persistence.*;

public class StoreDTO {
    Integer storeId;
    String storeName;
    String branch;
    CompanyDTO companyDTO;
    AddressDTO addressDTO;

    public StoreDTO(Integer storeId, String storeName, String branch, CompanyDTO companyDTO, AddressDTO addressDTO) {
        this.storeId = storeId;
        this.storeName = storeName;
        this.branch = branch;
        this.companyDTO = companyDTO;
        this.addressDTO = addressDTO;
    }
    public StoreDTO() {}

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
