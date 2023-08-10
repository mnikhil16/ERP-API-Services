package com.main.dto;

public class PurchaseInvoiceItemDTO {
    Integer purchaseInvoiceItemId;
    Integer quantity;
    Double amount;
    StoreDTO storeDTO;
    StockItemDTO stockItemDTO;
    PurchaseInvoiceDTO purchaseInvoiceDTO;

    public PurchaseInvoiceItemDTO(){}

    public PurchaseInvoiceItemDTO(Integer purchaseInvoiceItemId, Integer quantity, Double amount, StoreDTO storeDTO, StockItemDTO stockItemDTO, PurchaseInvoiceDTO purchaseInvoiceDTO) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
        this.quantity = quantity;
        this.amount = amount;
        this.storeDTO = storeDTO;
        this.stockItemDTO = stockItemDTO;
        this.purchaseInvoiceDTO = purchaseInvoiceDTO;
    }

    public Integer getPurchaseInvoiceItemId() {
        return purchaseInvoiceItemId;
    }

    public void setPurchaseInvoiceItemId(Integer purchaseInvoiceItemId) {
        this.purchaseInvoiceItemId = purchaseInvoiceItemId;
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

    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }

    public StockItemDTO getStockItemDTO() {
        return stockItemDTO;
    }

    public void setStockItemDTO(StockItemDTO stockItemDTO) {
        this.stockItemDTO = stockItemDTO;
    }

    public PurchaseInvoiceDTO getPurchaseInvoiceDTO() {
        return purchaseInvoiceDTO;
    }

    public void setPurchaseInvoiceDTO(PurchaseInvoiceDTO purchaseInvoiceDTO) {
        this.purchaseInvoiceDTO = purchaseInvoiceDTO;
    }
}
