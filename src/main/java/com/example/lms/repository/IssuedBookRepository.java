package com.example.lms.repository;

import com.example.lms.model.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface IssuedBookRepository extends JpaRepository<IssuedBook, Integer> {
    Optional<Object> findByIbname(String ibname);
}
