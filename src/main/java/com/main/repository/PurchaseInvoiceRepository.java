package com.main.repository;

import com.main.entity.PurchaseInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing PurchaseInvoice entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on PurchaseInvoice objects.
 * The PurchaseInvoiceRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The PurchaseInvoiceRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to PurchaseInvoice entities.
 * It provides methods to find, save, update, and delete PurchaseInvoice objects in the data store.
 */
@Repository
public interface PurchaseInvoiceRepository extends JpaRepository<PurchaseInvoice, Integer> {
    // Methods from JpaRepository are inherited automatically.
}