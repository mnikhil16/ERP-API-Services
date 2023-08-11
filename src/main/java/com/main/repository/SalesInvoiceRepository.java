package com.main.repository;

import com.main.entity.SalesInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing SalesInvoice entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on SalesInvoice objects.
 * The SalesInvoiceRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The SalesInvoiceRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to SalesInvoice entities.
 * It provides methods to find, save, update, and delete PalesInvoice objects in the data store.
 */
@Repository
public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, Integer> {
    // Methods from JpaRepository are inherited automatically.
}