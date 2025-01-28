package com.example.ob_rest_datajpa.controller;

import com.example.ob_rest_datajpa.entities.Book;
import com.example.ob_rest_datajpa.repository.ibookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    // CRUD sobre la entidad Book

    private ibookRepository bookRepository;

    public BookController(ibookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Buscar todos los libros
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // Recuperar y devolver los libros de base de datos
        return bookRepository.findAll();
    }

    // Buscar un solo libro en base de datos segun su id
    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
       Optional<Book> BookOpt =  bookRepository.findById(id);
        if (BookOpt.isPresent()) {
            return ResponseEntity.ok(BookOpt.get());
        }else{
        return ResponseEntity.notFound().build();
     }

    }

    // Crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book){
        if (book.getId() != null) {
            log.warn("Trying to create a book with id");
            System.out.println("Trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }

    // Actualizar un libro existente en base de datos
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId() == null) {
            log.warn("Trying to create a book instead edit");
            System.out.println("Trying to create a book instead edit");
            return ResponseEntity.badRequest().build();
        }
        if (!bookRepository.existsById(book.getId())) {
            log.warn("Trying to edit a book not found");
            System.out.println("Trying to edit a book not found");
            return ResponseEntity.notFound().build();

        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }



    // Borrar un libro en base de datos
      @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id ){
          if (!bookRepository.existsById(id)) {
              log.warn("Trying to delete a book not found");
              System.out.println("Trying to delete a book not found");
              return ResponseEntity.notFound().build();

          }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //Borrar todos los libros
    @DeleteMapping("api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("REST request for deleting all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();

    }


}

