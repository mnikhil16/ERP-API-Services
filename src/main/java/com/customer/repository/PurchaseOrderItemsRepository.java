package com.customer.repository;


import com.customer.beans.PurchaseOrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing PurchaseOrderItems entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on PurchaseOrderItems objects.
 *
 * The PurchaseOrderItemsRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 *
 * Usage:
 * The PurchaseOrderItemsRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to PurchaseOrderItems entities.
 * It provides methods to find, save, update, and delete PurchaseOrderItems objects in the data store.
 */
@Repository
public interface PurchaseOrderItemsRepository extends JpaRepository<PurchaseOrderItems,Integer> {
    // Methods from JpaRepository are inherited automatically.
}