package com.main.repository;

import com.main.beans.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing SalesItem entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on SalesItem objects.
 * The SalesItemsRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 * Usage:
 * The SalesItemsRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to SalesItem entities.
 * It provides methods to find, save, update, and delete SalesItem objects in the data store.
 */
@Repository
public interface SalesItemRepository extends JpaRepository<SalesItem,Integer> {
    // Methods from JpaRepository are inherited automatically.
}