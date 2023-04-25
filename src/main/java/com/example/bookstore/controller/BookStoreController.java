package com.example.bookstore.controller;


import com.example.bookstore.respository.BookStoreDao;
import com.example.bookstore.service.BookStoreService;
import com.example.bookstore.vo.BookStoreRequest;
import com.example.bookstore.vo.BookStoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookStoreController {

    @Autowired
    private BookStoreService bookStoreService;

    @PostMapping(value = "add_book_info")
    public BookStoreResponse addBookInfo(@RequestBody BookStoreRequest request) {
    return bookStoreService.addBookInfo(request.getBookSaleList());
    }
}
