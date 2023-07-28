package com.customer.repository;

import com.customer.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing Customer entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on Customer objects.
 *
 * The CustomerRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 *
 * Usage:
 * The CustomerRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to Customer entities.
 * It provides methods to find, save, update, and delete Customer objects in the data store.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    // Methods from JpaRepository are inherited automatically.
}
