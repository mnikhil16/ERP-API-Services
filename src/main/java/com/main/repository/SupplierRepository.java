package com.main.repository;

import com.main.beans.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing Supplier entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on Supplier objects.
 * The SupplierRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The SupplierRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to Customer entities.
 * It provides methods to find, save, update, and delete Supplier objects in the data store.
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    // Methods from JpaRepository are inherited automatically.
}