package com.example.bookstore.respository;

import com.example.bookstore.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreDao extends JpaRepository<BookStore, String> {

    public List<BookStore> findAllByCategoryContaining(String category);

    public List<BookStore> findByBooknameOrAuthorOrIsbnContaining(String name, String name1, String name3);

    public List<BookStore> findTop5ByOrderBySalesDesc();

    public List<BookStore> findAllByBooknameIn(List<String> list);

    public List<BookStore> findAllByIsbn(String isbn);


//    @Transactional
//    @Modifying
//    @Query("select b.bookname , b.price, b.author , b.isbn " +
//            "from BookStore b order by b.sales desc ")
//    public List<String> all();

//    @Query("select b.bookname , b.price, b.author , b.isbn " +
//            "from BookStore b where b.bookname like %:key%")
//    public List<Book> byBookNameOrAuthor(@Param("key")String name);

    @Query("select b.bookname  from BookStore b where b.bookname like %:key%")
    public String byBookName(@Param("key")String name);

}
