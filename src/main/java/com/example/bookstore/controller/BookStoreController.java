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

    @PostMapping(value = "find_by_category")
    public BookStoreResponse findByCategory(@RequestBody BookStoreRequest request) {
        return bookStoreService.findBycategory(request);
    }

    @PostMapping(value = "find_by_bookname")
    public BookStoreResponse findByBookNameOrAuthor(@RequestBody BookStoreRequest request){
        return bookStoreService.findByBookNameOrAuthor(request);
    }

    @PostMapping(value = "update_book_info")
    public BookStoreResponse updatebookinfo(@RequestBody BookStoreRequest request){
        return bookStoreService.updateBookInfo(request);
    }


    @PostMapping(value = "book_rank")
    public BookStoreResponse bookRank(@RequestBody BookStoreRequest request){
        return bookStoreService.saleRanking(request.getBookSaleList());
    }

    @PostMapping(value = "order_book")
    public BookStoreResponse orderBook(@RequestBody BookStoreRequest request){
        return bookStoreService.orderBook(request.getOrderMap());
    }
}
