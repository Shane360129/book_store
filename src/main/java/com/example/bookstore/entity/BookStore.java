package com.example.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "book_sale")
public class BookStore {


        @Column(name = "bookname")
        private String bookname;

        @Id
        @Column(name = "isbn")
        private String isbn;

        @Column(name = "author")
        private String author;

        @Column(name = "price")
        private int price;

        @Column(name = "stock")
        private int stock;

        @Column(name = "sales")
        private int sales;

        @Column(name = "category")
        private String category;

    public BookStore() {
    }

    public BookStore(String bookname, String isbn, String author, int price, int stock, int sales, String category) {
        this.bookname = bookname;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.category = category;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
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

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
