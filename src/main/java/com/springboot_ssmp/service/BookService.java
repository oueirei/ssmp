package com.springboot_ssmp.service;

import com.springboot_ssmp.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book getBook(Integer id);
    boolean updateBook(Book book);
    boolean deleteBook(Integer id);
    boolean insertBook(Book book);
    List<Book> selectAllBooks();
    List<Book> selectPageSer(Integer nowPage,Integer pageSIze);
    List<Book> selectBooksByType(String colStr);

}
