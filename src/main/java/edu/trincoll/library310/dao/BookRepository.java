package edu.trincoll.library310.dao;

import edu.trincoll.library310.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}

