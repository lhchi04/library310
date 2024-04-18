# Personal Library Management System

This Spring Boot application is designed to manage a collection of books in a personal library. It provides RESTful endpoints to perform CRUD operations on the collection of books stored in an H2 database.

## Table of Contents
- [About](#about)
- [Setup](#setup)
- [Testing](#testing)

## About

- **Book**: A Java POJO representing a book, containing fields for title, author, ISBN, publication date, and id. Validation constraints are added to ensure data integrity.
- **BookController**: A REST controller providing endpoints to manage the collection of books. It includes methods to get all books, add a new book, and delete an existing book by id. Additional methods can be added as needed or convenient.
- **H2 Database**: Data persistence is achieved using an H2 in-memory database.
- **JpaRepository**: The BookRepository interface extends JpaRepository for CRUD operations on the Book entity.
- **Validation Constraints**: Validation constraints are applied to the fields in the Book entity to enforce data validity.
- **Testing**: The BookController includes test cases to ensure the functionality is working as expected.

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/lhchi04/library310.git
   ```
2. Navigate to the project directory:
    ```bash
    cd library310
    ```
3. Build the project using Gradle:
    ```bash
    ./gradlew build
    ```
4. Run the applications:
   
    Run Library310Application

The application should now be running and accessible at http://localhost/8080/books

