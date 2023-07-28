package com.customer.repository;

import com.customer.beans.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface represents the repository for managing Address entities in the data store.
 * It provides methods to perform CRUD (Create, Read, Update, Delete) operations on Address objects.
 *
 * The AddressRepository interface extends JpaRepository from Spring Data JPA,
 * which provides convenient methods for interacting with the data store.
 *
 * Usage:
 * The AddressRepository is used to interact with the underlying data store (e.g., a database)
 * and perform operations related to Address entities.
 * It provides methods to find, save, update, and delete Address objects in the data store.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address,Integer>{
    // Methods from JpaRepository are inherited automatically.
}
