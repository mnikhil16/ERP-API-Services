package com.customer.repository;

import com.customer.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface represents the repository for managing Company entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on Company objects.
 *
 * The CompanyRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 *
 * Usage:
 * The CompanyRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to Company entities.
 * It provides methods to find, save, update, and delete Company objects in the data store.
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    // Methods from JpaRepository are inherited automatically.
}
