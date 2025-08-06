package com.springboot_ssmp.dao;

import com.springboot_ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.ErrorResponse;

import java.util.List;

@SpringBootTest
public class BookDaoTestCase {
     @Autowired
     BookDao bookDao;
     @Test
     void getTest() {
         System.out.println(bookDao.getBook(2));
     }

     @Test
     void updateTest() {
          Book book = new Book();
          book.setId(3);
          book.setType("アニメ");
          book.setName("update123");
          book.setDescription("update123");
          bookDao.updateBook(book);
     }

     @Test
     void delectTest() {
          bookDao.deleteBook(5);
     }

     @Test
     void insertTest() {
          Book book = new Book();
          book.setType("小説");
          book.setName("insert123");
          book.setDescription("insert123");
          bookDao.insertBook(book);
     }
     @Test
     void selectAllBooksTest(){
          List<Book> books = bookDao.selectAllBooks();
          books.forEach(System.out::println);
     }
     @Test
     void selectPage(){
          int nowPage = 3;
          int pageSize = 5;
          int endRow = nowPage * pageSize;
          int startRow = (nowPage-1) * pageSize;
          List<Book>  books = bookDao.selectPage(endRow,startRow);
     }
     @Test
     void selectBooksByColTest(){
          String colStr = "アニメ";
          List<Book> books = bookDao.selectBooksByType(colStr);
     }
}
