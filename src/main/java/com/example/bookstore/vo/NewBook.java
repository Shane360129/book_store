package com.example.bookstore.vo;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class NewBook {

    private String bookName;

    private int price;

    private int sale;

    private int stock;

    private String isbn;

    public NewBook() {
    }

    public NewBook(String bookName, int price, int sale, int stock) {
        this.bookName = bookName;
        this.price = price;
        this.sale = sale;
        this.stock = stock;
    }

    public NewBook(String bookName, int price, int sale, int stock, String isbn) {
        this.bookName = bookName;
        this.price = price;
        this.sale = sale;
        this.stock = stock;
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
}
