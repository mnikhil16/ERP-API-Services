package com.customer.repository;

import com.customer.beans.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing PurchaseOrder entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on PurchaseOrder objects.
 * The PurchaseOrderRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The PurchaseOrderRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to PurchaseOrder entities.
 * It provides methods to find, save, update, and delete PurchaseOrder objects in the data store.
 */
@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Integer> {
    // Methods from JpaRepository are inherited automatically.
}