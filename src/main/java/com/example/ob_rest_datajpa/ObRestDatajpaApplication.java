package com.example.ob_rest_datajpa;

import com.example.ob_rest_datajpa.entities.Book;
import com.example.ob_rest_datajpa.repository.ibookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);

		ibookRepository bookRepository = context.getBean(ibookRepository.class);

		// CRUD
		// CREATE

		Book Peterpan = new Book(null, "Peter Pan", "Fernando del Toro", 200, 14.99, LocalDate.of(1972,9,1), true );
		Book Cinderella = new Book(null, "Cinderella", "Bernardo Stamatheas", 500, 20.99, LocalDate.of(2004,4,5), true );

		// SAVE
		System.out.println("Numero de libros almacenados en DB: " + bookRepository.findAll().size());
		bookRepository.save(Peterpan);
		bookRepository.save(Cinderella);

		// READ
		System.out.println("Numero de libros almancenados en DB: " + bookRepository.findAll().size());
		System.out.println(Peterpan);
		System.out.println(Cinderella);
		//DELEETE

		//bookRepository.deleteById(1L);
		System.out.println("Numero de libros almancenados en DB: " + bookRepository.findAll().size());





	}

}
