package com.springboot_ssmp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot_ssmp.controller.utils.Ret;
import com.springboot_ssmp.domain.Book;
import com.springboot_ssmp.service.BookService;


/*
 * @ 初めて編集
 * @二回目編集
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Ret selectAllBookse(){

        return new Ret(true,bookService.selectAllBooks());
    }

    @GetMapping("{id}")
    public Ret getBook(@PathVariable Integer id){
        System.out.println("test hot deploy...");
        System.out.println("test hot deploy...");

        return new Ret(true,bookService.getBook(id));
    }

    @PostMapping
    public Ret insertBook(@RequestBody Book book) throws IOException {
//        Ret ret = new Ret();
//        boolean flag = bookService.insertBook(book);
//        ret.setFlag(flag);
        //異常処理のtest
        if(book.getType().equals("アニメ")) throw new IOException();
        boolean flag = bookService.insertBook(book);
        return new Ret(flag,flag ? "success":"failed");

        //如果不编译异常处理消息*mes时，用下面的直接return
        //return new Ret(bookService.insertBook(book));
    }
    @PutMapping
    public Ret updateBook(@RequestBody Book book){
        return new Ret(bookService.updateBook(book));
    }
    @DeleteMapping("{id}")
    public Ret deleteBook(@PathVariable Integer id){
        return new Ret(bookService.deleteBook(id));
    }

    @GetMapping("{nowPage}/{pageSize}")
    public Ret selectPageSer(@PathVariable Integer nowPage,
                                    @PathVariable Integer pageSize){
        List<Book> books = bookService.selectPageSer(nowPage,pageSize);
        int total = bookService.selectAllBooks().size();
        Map<String,Object> mapRec = new HashMap<>();
        mapRec.put("records",books);
        mapRec.put("total",total);
        mapRec.put("pageSize",pageSize);
        mapRec.put("nowPage",nowPage);
        return new Ret(true,mapRec);
    }

    @GetMapping("/type/{colStr}")
    public Ret selectBooksByCol(@PathVariable String colStr){
        return new Ret(true,bookService.selectBooksByType(colStr));
    }





}
