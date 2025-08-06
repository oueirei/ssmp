package com.springboot_ssmp.service;

import com.springboot_ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService  bookService;

    @Test
    void getBookTest(){
        System.out.println(bookService.getBook(1));
    }
    @Test
    void updateBookTest(){
        Book book = new Book();
        book.setId(9);
        book.setType("anime");
        book.setName("update456");
        book.setDescription("update456");
        System.out.println(bookService.updateBook(book));

    }
    @Test
    void delectTest() {
        System.out.println(bookService.deleteBook(20));
    }

    @Test
    void insertTest() {
        Book book = new Book();
        book.setType("小説");
        book.setName("insert123");
        book.setDescription("insert123");
        System.out.println(bookService.insertBook(book));
    }
    @Test
    void selectAllBooksTest(){
        List<Book> books = bookService.selectAllBooks();
        books.forEach(System.out::println);
    }
    @Test
    void selectPage(){
        List<Book>  books = bookService.selectPageSer(3,3);
        books.forEach(System.out::println);
    }
    @Test
    void selectBooksByColTest(){
        String colStr = "アニメ";
        List<Book> books = bookService.selectBooksByType(colStr);
        books.forEach(System.out::println);
    }


}
