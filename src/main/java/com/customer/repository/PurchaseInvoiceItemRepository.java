package com.customer.repository;

import com.customer.beans.PurchaseInvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing PurchaseInvoiceItem entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on PurchaseInvoiceItem objects.
 * The PurchaseInvoiceItemsRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The PurchaseInvoiceItemsRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to PurchaseInvoiceItem entities.
 * It provides methods to find, save, update, and delete PurchaseInvoiceItem objects in the data store.
 */
@Repository
public interface PurchaseInvoiceItemRepository extends JpaRepository<PurchaseInvoiceItem, Integer> {
    // Methods from JpaRepository are inherited automatically.
}