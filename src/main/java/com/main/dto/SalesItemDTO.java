package com.main.dto;

public class SalesItemDTO {
    Integer salesItemId;
    Integer quantity;
    Double amount;
    SalesInvoiceDTO salesInvoiceDTO;
    StockItemDTO stockItemDTO;

    public SalesItemDTO(){}

    public SalesItemDTO(Integer salesItemId, Integer quantity, Double amount, SalesInvoiceDTO salesInvoiceDTO, StockItemDTO stockItemDTO) {
        this.salesItemId = salesItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.salesInvoiceDTO = salesInvoiceDTO;
        this.stockItemDTO = stockItemDTO;
    }

    public Integer getSalesItemId() {
        return salesItemId;
    }

    public void setSalesItemId(Integer salesItemId) {
        this.salesItemId = salesItemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public SalesInvoiceDTO getSalesInvoiceDTO() {
        return salesInvoiceDTO;
    }

    public void setSalesInvoiceDTO(SalesInvoiceDTO salesInvoiceDTO) {
        this.salesInvoiceDTO = salesInvoiceDTO;
    }

    public StockItemDTO getStockItemDTO() {
        return stockItemDTO;
    }

    public void setStockItemDTO(StockItemDTO stockItemDTO) {
        this.stockItemDTO = stockItemDTO;
    }
}
