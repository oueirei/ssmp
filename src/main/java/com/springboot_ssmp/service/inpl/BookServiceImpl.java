package com.springboot_ssmp.service.inpl;

import com.springboot_ssmp.dao.BookDao;
import com.springboot_ssmp.domain.Book;
import com.springboot_ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book getBook(Integer id) {
        return bookDao.getBook(id);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookDao.updateBook(book)>0;
    }

    @Override
    public boolean deleteBook(Integer id) {
        return bookDao.deleteBook(id)>0;
    }

    @Override
    public boolean insertBook(Book book) {
        return bookDao.insertBook(book)>0;
    }

    @Override
    public List<Book> selectAllBooks() {
        return bookDao.selectAllBooks();
    }

    @Override
    public List<Book> selectPageSer(Integer nowPage, Integer pageSize) {
        return bookDao.selectPage(
                nowPage * pageSize,(nowPage-1) * pageSize);
    }

    @Override
    public List<Book> selectBooksByType(String colStr) {
        return bookDao.selectBooksByType(colStr);
    }


}
