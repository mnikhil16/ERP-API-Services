package com.main.dto;

/**
 * Data Transfer Object (DTO) class representing a company entity.
 */
public class CompanyDTO {
    Integer companyId; // Unique identifier for the company.
    String companyName; // Name of the company.
    String type; // Type of the company (e.g., industry sector).
    String website; // Company's website URL.
    String gst; // Goods and Services Tax (GST) identification number.
    AddressDTO addressDTO; // Address details associated with the company.

    /**
     * Default constructor for the CompanyDTO class.
     */
    public CompanyDTO() {
    }

    /**
     * Parameterized constructor to create a CompanyDTO object with specified details.
     *
     * @param companyId    The unique identifier for the company.
     * @param companyName The name of the company.
     * @param type         The type or industry sector of the company.
     * @param website      The website URL of the company.
     * @param gst          The GST identification number of the company.
     * @param addressDTO   The AddressDTO object containing the company's address details.
     */
    public CompanyDTO(Integer companyId, String companyName, String type, String website, String gst, AddressDTO addressDTO) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.type = type;
        this.website = website;
        this.gst = gst;
        this.addressDTO = addressDTO;
    }

    // Getters and setters for class fields.

    /**
     * Get the unique identifier for the company.
     *
     * @return The company id.
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * Set the unique identifier for the company.
     *
     * @param companyId The company id to set.
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
     * Get the type or industry sector of the company.
     *
     * @return The company type.
     */
    public String getType() {
        return type;
    }

    /**
     * Set the type or industry sector of the company.
     *
     * @param type The company type to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get the website URL of the company.
     *
     * @return The company website URL.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Set the website URL of the company.
     *
     * @param website The company website URL to set.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Get the GST identification number of the company.
     *
     * @return The company's GST identification number.
     */
    public String getGst() {
        return gst;
    }

    /**
     * Set the GST identification number of the company.
     *
     * @param gst The company's GST identification number to set.
     */
    public void setGst(String gst) {
        this.gst = gst;
    }

    /**
     * Get the AddressDTO object containing the company's address details.
     *
     * @return The AddressDTO object.
     */
    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    /**
     * Set the AddressDTO object containing the company's address details.
     *
     * @param addressDTO The AddressDTO object to set.
     */
    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }
}
