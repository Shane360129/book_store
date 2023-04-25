package com.example.bookstore.respository;

import com.example.bookstore.entity.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreDao extends JpaRepository<BookStore, String> {

    public List<BookStore> findAllByCategory(String category);
}
