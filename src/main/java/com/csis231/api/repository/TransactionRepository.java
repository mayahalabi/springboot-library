package com.csis231.api.repository;

import com.csis231.api.DTO.TransactionDTO;
import com.csis231.api.model.Book;
import com.csis231.api.model.Transaction;
import com.csis231.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repository interface for Transaction entity, extending JpaRepository for CRUD operations.
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Checks if a transaction exists for the given book and user
    boolean existsByBookAndUser(Book book, User user);

    // Retrieves the transaction associated with the given book and user
    Transaction findByBookAndUser(Book book, User user);

    @Query("SELECT t FROM Transaction t WHERE t.user.username = :username")
    List<Transaction> findTransactionsByUsername(@Param("username") String username);



}
