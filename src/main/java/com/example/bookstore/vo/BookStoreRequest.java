package com.example.bookstore.vo;

import com.example.bookstore.entity.BookStore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class BookStoreRequest {

    private List<BookStore> bookSaleList;

    private String message;

    private String category;

    private String customers;

    private String booksales;

    private String bookname;

    private String author;

    private int stock;

    private int price;

    private int sales;

    @JsonProperty("order_book")
    private Map<String, Integer> orderMap;


    public Map<String, Integer> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, Integer> orderMap) {
        this.orderMap = orderMap;
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCustomers() {
        return customers;
    }

    public void setCustomers(String customers) {
        this.customers = customers;
    }

    public String getBooksales() {
        return booksales;
    }

    public void setBooksales(String booksales) {
        this.booksales = booksales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

}
