package com.main.dto;

public class SupplierDTO {
    Integer supplierId;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    StoreDTO storeDTO;
    CompanyDTO companyDTO;
    AddressDTO addressDTO;

    public SupplierDTO(){}

    public SupplierDTO(Integer supplierId, String firstName, String lastName, String email, String phoneNumber, StoreDTO storeDTO, CompanyDTO companyDTO, AddressDTO addressDTO) {
        this.supplierId = supplierId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.storeDTO = storeDTO;
        this.companyDTO = companyDTO;
        this.addressDTO = addressDTO;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
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
