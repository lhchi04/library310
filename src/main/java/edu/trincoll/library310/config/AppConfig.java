package edu.trincoll.library310.config;

import edu.trincoll.library310.dao.BookRepository;
import edu.trincoll.library310.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class AppConfig implements CommandLineRunner {
    private final BookRepository repository;

    @Autowired
    public AppConfig(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(
                List.of(
                        new Book("Winnie the Pooh", "A. A. Milne", "9780416239102", LocalDate.of(2004, 3,9)),
                        new Book("How to take a nap correctly", "Vysa Nguyen", "125-1-20035-125-4", LocalDate.of(2003, 12,5)),
                        new Book("How to procrastinate", "Chi Le", "2004424240", LocalDate.of(2004, 4,24)),
                        new Book("How to spend money on unnecessary things", "Pom Somchanmavong", "0-153-20013-9", LocalDate.of(2001, 3,15))
                )).forEach(System.out::println);
    }
}

