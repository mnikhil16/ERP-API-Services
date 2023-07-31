package com.customer.repository;

import com.customer.beans.PurchaseInvoiceItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing PurchaseInvoiceItems entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on PurchaseInvoiceItems objects.
 * The PurchaseInvoiceItemsRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The PurchaseInvoiceItemsRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to PurchaseInvoiceItems entities.
 * It provides methods to find, save, update, and delete PurchaseInvoiceItems objects in the data store.
 */
@Repository
public interface PurchaseInvoiceItemsRepository extends JpaRepository<PurchaseInvoiceItems, Integer> {
    // Methods from JpaRepository are inherited automatically.
}