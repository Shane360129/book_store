package com.example.bookstore.service;

import com.example.bookstore.entity.BookStore;
import com.example.bookstore.vo.BookStoreRequest;
import com.example.bookstore.vo.BookStoreResponse;

import java.util.List;

public interface BookStoreService {

    public BookStoreResponse addBookInfo (List<BookStore> bookStoreList);

    public BookStoreResponse findBycategory(BookStoreRequest requst);
}
