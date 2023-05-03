package com.example.bookstore.vo;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Customers {

    private String bookName;

    private String isbn;

    private String author;

    private int price;

    private int stock;

    public Customers(String bookName, String isbn, String author, int price) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
    }

    public Customers(String bookName, String isbn, String author, int price, int stock) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
