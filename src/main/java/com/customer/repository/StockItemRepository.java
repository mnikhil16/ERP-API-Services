package com.customer.repository;

import com.customer.beans.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing StockItem entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on StockItem objects.
 *
 * The StockItemRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 *
 * Usage:
 * The StockItemRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to StockItem entities.
 * It provides methods to find, save, update, and delete StockItem objects in the data store.
 */
@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Integer> {
    // Methods from JpaRepository are inherited automatically.
}
