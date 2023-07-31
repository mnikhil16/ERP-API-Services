package com.customer.repository;

import com.customer.beans.SalesItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing SalesItems entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on SalesItems objects.
 * The SalesItemsRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The SalesItemsRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to SalesItems entities.
 * It provides methods to find, save, update, and delete SalesItems objects in the data store.
 */
@Repository
public interface SalesItemsRepository extends JpaRepository<SalesItems,Integer> {
    // Methods from JpaRepository are inherited automatically.
}