package com.main.dto;

import jakarta.persistence.*;

public class PurchaseInvoiceItemDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_invoice_items_id")
    Integer purchaseInvoiceItemId;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "amount")
    Double amount;

    @ManyToOne
    @JoinColumn(name = "store_id")
    StoreDTO storeDTO;

    @ManyToOne
    @JoinColumn(name = "stock_item_id")
    StockItemDTO stockItemDTO;

    @ManyToOne
    @JoinColumn(name = "purchase_invoice_id")
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
