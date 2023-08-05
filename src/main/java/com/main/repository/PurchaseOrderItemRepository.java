package com.main.repository;


import com.main.beans.PurchaseOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing PurchaseOrderItem entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on PurchaseOrderItem objects.
 * The PurchaseOrderItemRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The PurchaseOrderItemRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to PurchaseOrderItem entities.
 * It provides methods to find, save, update, and delete PurchaseOrderItem objects in the data store.
 */
@Repository
public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem,Integer> {
    // Methods from JpaRepository are inherited automatically.
}