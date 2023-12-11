package edu.trincoll.library310.dao;

import edu.trincoll.library310.entities.Book;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    void autowiringWorked() {
        assertNotNull(repository);
    }

    @Test
    void countBooks() {
        assertEquals(4, repository.count());
    }

    @Test
    void findAll() {
        List<Book> books = repository.findAll();
        assertEquals(4, books.size());
    }

    @Test
    void findById() {
        assertTrue(repository.findById(1L).isPresent());
    }

    @Test
    void insertBook() {
        Book newBook = new Book("10 (0) ways to finish your homework on time","Chi Le", "1234567890123", LocalDate.of(2024, 12,11));
        repository.save(newBook);
        assertNotNull(newBook.getId());
        System.out.println(newBook);
    }

    @Test
    void deleteBook() {
        repository.deleteById(1L);
        assertEquals(3, repository.count());
    }

    @Test
    void deleteAllBooks() {
        repository.deleteAll();
        assertEquals(0, repository.count());
    }
}
