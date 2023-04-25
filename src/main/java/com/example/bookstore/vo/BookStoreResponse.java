package com.example.bookstore.vo;

import com.example.bookstore.entity.BookStore;

import java.util.List;

public class BookStoreResponse {

    private List<BookStore> bookSaleList;

    private String message;

    public BookStoreResponse() {
    }

    public BookStoreResponse(String message) {
        this.message = message;
    }

    public BookStoreResponse(List<BookStore> bookSaleList) {
        this.bookSaleList = bookSaleList;
    }

    public BookStoreResponse(List<BookStore> bookSaleList, String message) {
        this.bookSaleList = bookSaleList;
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
