package com.example.bookstore.vo;

import com.example.bookstore.entity.BookStore;

import java.util.List;

public class BookStoreRequest {

    private List<BookStore> bookSaleList;

    private String message;

    public BookStoreRequest() {
    }

    public BookStoreRequest(List<BookStore> bookSaleList) {
        this.bookSaleList = bookSaleList;
    }

    public BookStoreRequest(String message) {
        this.message = message;
    }

    public List<BookStore> getBookSaleList() {
        return bookSaleList;
    }

    public void setBookSaleList(List<BookStore> bookSaleList) {
        this.bookSaleList = bookSaleList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
