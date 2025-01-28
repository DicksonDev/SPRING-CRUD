package com.example.ob_rest_datajpa.Service;

import com.example.ob_rest_datajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {

        Book book = new Book(1L, "WINNIE POOH", "William Dafoe", 400, 29.99, LocalDate.of(2000, 5, 25), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

      double price =  calculator.calculatePrice(book);
        System.out.println(price);

      assertTrue(price > 0);
    }
}