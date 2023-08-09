package com.main.dto;

public class StockInventoryDTO {
    Integer stockInventoryId;
    Integer quantity;
    String lastStockDate;
    StockItemDTO stockItemDTO;
    StoreDTO storeDTO;
    SupplierDTO supplierDTO;

    public StockInventoryDTO(){}

    public StockInventoryDTO(Integer stockInventoryId, Integer quantity, String lastStockDate, StockItemDTO stockItemDTO, StoreDTO storeDTO, SupplierDTO supplierDTO) {
        this.stockInventoryId = stockInventoryId;
        this.quantity = quantity;
        this.lastStockDate = lastStockDate;
        this.stockItemDTO = stockItemDTO;
        this.storeDTO = storeDTO;
        this.supplierDTO = supplierDTO;
    }

    public Integer getStockInventoryId() {
        return stockInventoryId;
    }

    public void setStockInventoryId(Integer stockInventoryId) {
        this.stockInventoryId = stockInventoryId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getLastStockDate() {
        return lastStockDate;
    }

    public void setLastStockDate(String lastStockDate) {
        this.lastStockDate = lastStockDate;
    }

    public StockItemDTO getStockItemDTO() {
        return stockItemDTO;
    }

    public void setStockItemDTO(StockItemDTO stockItemDTO) {
        this.stockItemDTO = stockItemDTO;
    }

    public StoreDTO getStoreDTO() {
        return storeDTO;
    }

    public void setStoreDTO(StoreDTO storeDTO) {
        this.storeDTO = storeDTO;
    }

    public SupplierDTO getSupplierDTO() {
        return supplierDTO;
    }

    public void setSupplierDTO(SupplierDTO supplierDTO) {
        this.supplierDTO = supplierDTO;
    }
}
