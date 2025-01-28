package com.example.ob_rest_datajpa.repository;

import com.example.ob_rest_datajpa.entities.Book;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ibookRepository extends JpaRepositoryImplementation <Book, Long> {
}
