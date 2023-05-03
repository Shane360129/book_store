package com.example.bookstore.vo;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Book {

    private String bookName;

    private String isbn;

    private String author;

    private int price;

    private int sale;

    private int stock;

    private int totalPrice;

    private String catrgory;

    public Book(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Book(String bookName, String isbn, int price, int stock) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.price = price;
        this.stock = stock;
    }

    public Book(String bookName, String isbn, String author, int price) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
    }

    public Book(String bookName, String isbn, String author, int price, String catrgory) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.catrgory = catrgory;
    }

    public Book(String bookName, String isbn, String author, int price, int sale, int stock) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.sale = sale;
        this.stock = stock;
    }

    public Book(String bookName, String isbn, String author, int price, int stock) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    public Book() {

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCatrgory() {
        return catrgory;
    }

    public void setCatrgory(String catrgory) {
        this.catrgory = catrgory;
    }

}
