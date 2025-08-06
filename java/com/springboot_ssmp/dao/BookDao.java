package com.springboot_ssmp.dao;

import com.springboot_ssmp.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {

    @Select("select * from books where id = #{id}")
    public Book getBook(Integer id);

    @Update("update books set type =#{type},name = #{name},description= #{description}" +
            "where id = #{id}")
    public int updateBook(Book book);

    @Delete("delete from books where id =#{id}")
    public int deleteBook(Integer id);

    @Insert("insert into books(type,name,description)" +
            "values(#{type},#{name},#{description})")
    public int insertBook(Book book);

    @Select("select * from books")
    public List<Book> selectAllBooks();

    @Select("SELECT * FROM (\n" +
            "    SELECT ROWNUM AS rowno, t.*\n" +
            "    FROM (\n" +
            "        SELECT * FROM books ORDER BY id\n" +
            "    ) t\n" +
            "    WHERE ROWNUM <= #{endRow}\n" +
            ")\n" +
            "WHERE rowno > #{startRow}")
    public List<Book> selectPage(@Param("endRow") int endRow,@Param("startRow") int startRow);

    @Select("select * from books where type like '%' || LOWER(#{colStr}) || '%'")
    public List<Book> selectBooksByType(@Param("colStr") String colStr);



}

