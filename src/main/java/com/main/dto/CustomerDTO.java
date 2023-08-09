package com.main.dto;


public class CustomerDTO {
    Integer customerId;
    String firstName;
    String lastName;
    String displayName;
    String dateOfBirth;
    Integer age;
    String email;
    String phoneNumber;
    AddressDTO addressDTO;
    StoreDTO storeDTO;

    public CustomerDTO(){}

    public CustomerDTO(Integer customerId, String firstName, String lastName, String displayName, String dateOfBirth, Integer age, String email, String phoneNumber, AddressDTO addressDTO, StoreDTO storeDTO) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressDTO = addressDTO;
        this.storeDTO = storeDTO;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }
}
