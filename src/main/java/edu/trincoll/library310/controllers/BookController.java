package edu.trincoll.library310.controllers;

import edu.trincoll.library310.dao.BookRepository;
import edu.trincoll.library310.entities.Book;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository repository;

    @Autowired
    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @GetMapping("count")
    public long getBookCount() {
        return repository.count();
    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<Book> deleteBookById(@PathVariable Long id) {
//        repository.deleteById(id);
//        return ResponseEntity.noContent().build();
//    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        repository.save(book);
        URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(book.getId())
                .toUri();
        return ResponseEntity.created(location).body(book);
    }

    @PutMapping("{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody Book book) {
        return repository.findById(id)
                .map(p -> {
                    p.setTitle(book.getTitle());
                    p.setAuthor(book.getAuthor());
                    p.setISBN(book.getISBN());
                    p.setDate(book.getDate());
                    return ResponseEntity.ok(repository.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        return repository.findById(id)
                .map(p -> {
                    repository.delete(p);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAllBooks() {
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}

