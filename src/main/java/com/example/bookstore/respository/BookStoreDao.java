package com.example.bookstore.respository;

import com.example.bookstore.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookStoreDao extends JpaRepository<BookStore, String> {

    public List<BookStore> findAllByCategoryContaining(String category);

    public Optional<BookStore> findByBooknameOrAuthor(String name, String name1);

    public BookStore findByBookname(String name);

    public Optional <BookStore>findAllByBookname(String name);

    public List<BookStore> findTop3ByOrderBySalesDesc();

//    @Transactional
//    @Modifying
//    @Query("select b.bookname , b.price, b.author , b.isbn " +
//            "from BookStore b order by b.sales desc ")
//    public List<String> all();

//    @Query("select b.bookname , b.price, b.author , b.isbn " +
//            "from BookStore b where b.bookname like %:key%")
//    public List<Book> byBookNameOrAuthor(@Param("key")String name);

//    @Query("select b.bookname  from BookStore b where b.bookname like %:key%")
//    public String byBookName(@Param("key")String name);

}
