package com.example.bookstore.impl;

import com.example.bookstore.entity.BookStore;
import com.example.bookstore.respository.BookStoreDao;
import com.example.bookstore.service.BookStoreService;
import com.example.bookstore.vo.BookStoreRequest;
import com.example.bookstore.vo.BookStoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    BookStoreDao bookStoreDao;

    @Override
    public BookStoreResponse addBookInfo(List<BookStore> bookSaleList) {
        if (CollectionUtils.isEmpty(bookSaleList)) {
            return new BookStoreResponse("輸入資料不得為空");
        }
        List<String> bookIsbn = new ArrayList<>();
        for (BookStore info : bookSaleList) {
            if (!StringUtils.hasText(info.getIsbn())) {
                return new BookStoreResponse("ISBN不得為空");
            }
            if (!StringUtils.hasText(info.getBookname())) {
                return new BookStoreResponse("書名不得為空");
            }
            if (info.getPrice() < 0) {
                return new BookStoreResponse("價格輸入不得為負數");
            }
            if (info.getStock() < 0) {
                return new BookStoreResponse("庫存輸入不得為負數");
            }
            if(info.getIsbn().length() != 13){
                return new BookStoreResponse("ISBN為13碼");
            }
        }
        List<BookStore> result = bookStoreDao.findAllById(bookIsbn);
        if (result.size() > 0){
            return new BookStoreResponse("新增書籍已存在");
        }
        bookStoreDao.saveAll(bookSaleList);
        return new BookStoreResponse(bookSaleList , "新增書籍資料成功");
    }

    @Override
    public BookStoreResponse findBycategory(BookStoreRequest requst) {
        String category = requst.getMessage();
        List<BookStore> list = bookStoreDao.findAllByCategory(category);
        return null;
    }
}
