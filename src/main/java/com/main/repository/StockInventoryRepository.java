package com.main.repository;

import com.main.entity.StockInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing StockInventory entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on StockInventory objects.
 * The StockInventoryRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The StockInventoryRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to StockInventory entities.
 * It provides methods to find, save, update, and delete StockInventory objects in the data store.
 */
@Repository
public interface StockInventoryRepository extends JpaRepository<StockInventory, Integer> {
    // Methods from JpaRepository are inherited automatically.
}
