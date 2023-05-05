package com.example.bookstore.vo;

import com.example.bookstore.entity.BookStore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class BookStoreResponse {

    private List<BookStore> bookSaleList;

    private Book book;

    private Customers customers;

    private String message;

    private List<NewBook> bookList;

    private int totalPrice;

    private Map<String,Integer> orderMap;


    public BookStoreResponse() {
    }

    public BookStoreResponse(Customers customers) {
        this.customers = customers;
    }


    public BookStoreResponse(Book book) {
        this.book = book;
    }



    public BookStoreResponse(Book book, String message) {
        this.book = book;
        this.message = message;
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

    public BookStoreResponse(String message, List<NewBook> bookList) {
        this.message = message;
        this.bookList = bookList;
    }

    public BookStoreResponse(Book book, List<NewBook> bookList) {
        this.book = book;
        this.bookList = bookList;
    }

    public BookStoreResponse(String message, List<NewBook> bookList, int totalPrice) {
        this.message = message;
        this.bookList = bookList;
        this.totalPrice = totalPrice;
    }

    public BookStoreResponse(Map<String, Integer> orderMap, int totalPrice, String message) {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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

    public List<NewBook> getBookList() {
        return bookList;
    }

    public void setBookList(List<NewBook> bookList) {
        this.bookList = bookList;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<String, Integer> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, Integer> orderMap) {
        this.orderMap = orderMap;
    }
}
