package com.example.bookstore.impl;

import com.example.bookstore.entity.BookStore;
import com.example.bookstore.respository.BookStoreDao;
import com.example.bookstore.service.BookStoreService;
import com.example.bookstore.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class BookStoreServiceImpl implements BookStoreService {

    @Autowired
    BookStoreDao bookStoreDao;

    @Override
    public BookStoreResponse addBookInfo(List<BookStore> bookSaleList) {
        /*
        書名、ISBN、作者、價格、庫存數量、銷售量、分類(一本書籍可能會有多種分類)的新增、修改功能
        新增書籍資料
         */
        if (CollectionUtils.isEmpty(bookSaleList)) {
            return new BookStoreResponse("輸入資料不得為空");
        }
        //檢查資料是否為空
        List<String> bookIsbn = new ArrayList<>();
        for (BookStore info : bookSaleList) {
            if (!StringUtils.hasText(info.getIsbn())
                    || !StringUtils.hasText(info.getBookname())) {
                return new BookStoreResponse("ISBN或書名不得為空");
            }
            if (info.getPrice() < 0) {
                return new BookStoreResponse("價格輸入不得為負數");
            }
            if (info.getStock() < 0) {
                return new BookStoreResponse("庫存輸入不得為負數");
            }
            if (info.getIsbn().length() != 13) {
                return new BookStoreResponse("ISBN為13碼");
            }
            if (!info.getCategory().isBlank()) {
                return new BookStoreResponse("請輸入分類");
            }
            if (info.getCategory().lastIndexOf(",") != info.getCategory().length() - 1) {
                info.setCategory(info.getCategory() + ",");
            }
            //檢查輸入資訊是否有誤
        }

        List<BookStore> result = bookStoreDao.findAllById(bookIsbn);
        if (result.size() > 0) {
            return new BookStoreResponse("新增書籍已存在");
        }
        //檢查新增資訊是否已存在
        bookStoreDao.saveAll(bookSaleList);
        return new BookStoreResponse(bookSaleList, "新增書籍資料成功");
        //將資料加入資料庫
    }

    @Override
    public BookStoreResponse findBycategory(BookStoreRequest request) {
        /*
        書籍分類搜尋(一或多)，只顯示書名、ISBN、作者、價格、庫存量
        有符合其中一個搜尋條件即可
         */
        List<BookStore> op = bookStoreDao.findAllByCategoryContaining(request.getCategory());
        List<NewBook> list = new ArrayList<>();
        if (op.isEmpty()) {
            return new BookStoreResponse("輸入分類錯誤");
        }
        /*
        若有符合其中一個內容即可以查詢到該本書
         */
        for (int i = 0; i < op.size(); i++) {
            NewBook book = new NewBook(op.get(i).getBookname(),
                    op.get(i).getPrice(), op.get(i).getSales(),
                    op.get(i).getStock(), op.get(i).getIsbn());
            list.add(book);
        }
        return new BookStoreResponse("書籍查詢成功", list);
    }

    @Override
    public BookStoreResponse findByBookNameOrAuthor(BookStoreRequest request) {
        /*
        書籍搜尋
        消費者: (透過書名或ISBN或作者) ，只顯示書名、ISBN、作者、價格
        書籍商: (透過書名或ISBN或作者)，顯示書名、ISBN、作者、價格、銷售量、庫存量
         */
        String name = request.getBookname();
        String name1 = request.getAuthor();
        String name2 = request.getIsbn();
        Optional<BookStore> op = bookStoreDao.findByBooknameOrAuthorOrIsbnContaining(name, name1, name2);
        if (op.isEmpty()) {
            return new BookStoreResponse("輸入錯誤");
        }
        BookStore t = op.get();
//
        //分辨輸入者是消費者還是書商
//        使用boolean值去判斷
        if (!request.getCustomers().equals("消費者")
                && !request.getCustomers().equals("書籍商")) {
            return new BookStoreResponse("請輸入您是消費者還是書籍商");
        }
        if (request.getCustomers().equals("消費者")) {
            Customers a = new Customers(t.getBookname(),
                    t.getIsbn(), t.getAuthor(), t.getPrice());
            return new BookStoreResponse(a);
        }
        if (request.getCustomers().equals("書籍商")) {
            Book book2 = new Book(t.getBookname(), t.getIsbn(), t.getAuthor(),
                    t.getPrice(), t.getSales(), t.getStock());
            return new BookStoreResponse(book2);
        }
        //比對輸入資料
        return new BookStoreResponse("查詢成功");
    }

    @Override
    public BookStoreResponse updateBookInfo(BookStoreRequest request) {


        if (request == null) {
            return new BookStoreResponse("輸入資料不得為空");
        }

        List<BookStore> list = bookStoreDao.findAllByIsbn(request.getIsbn());
        if (list.isEmpty()) {
            return new BookStoreResponse("查無此書籍");
        }
        int purchase = request.getStock();
        int newPrice = request.getPrice();
        Set<String> set = new HashSet<>(Arrays.asList(request.getCategory()));
        String str = String.join(",", set);
        List<BookStore> saveList = new ArrayList<>();
        boolean update = false;
        for (BookStore a : list) {
            if (!a.getCategory().isEmpty()) {
                a.setCategory(a.getCategory() + str);
                update = true;
            }
            if (purchase > 0) {
                a.setStock(a.getStock() + purchase);
                update = true;
            }
            if (newPrice > 0) {
                a.setPrice(newPrice);
                update = true;
            }
            saveList.add(a);
        }
        if (update) {
            bookStoreDao.saveAll(saveList);
            return new BookStoreResponse(saveList, "更新成功");
        } else {
            return new BookStoreResponse("沒有更新內容");
        }
    }
//
    @Override
    public BookStoreResponse saleRanking(List<BookStore> bookStoreList) {
        /*
        列出銷量排行前三名
         */
        List<BookStore> list = bookStoreDao.findTop5ByOrderBySalesDesc();
        return new BookStoreResponse(list);
    }

    @Override
    public BookStoreResponse orderBook(Map<String, Integer> orderMap) {
        List<String> newList = new ArrayList<>();
        for (String key : orderMap.keySet()) {
            newList.add(key);
        }
        List<BookStore> res = bookStoreDao.findAllByBooknameIn(newList);
        List<NewBook> saveList = new ArrayList<>();
        int totalPrice = 0;
        for (BookStore bookStore : res) {
            for (Map.Entry<String, Integer> item : orderMap.entrySet()) {
                if (item.getValue() < 0) {
                    return new BookStoreResponse("輸入數量錯誤");
                }
                //依次比對Map中的Key值跟撈出來的資料
                String key = item.getKey();
                if (key.equals(bookStore.getBookname())) {
                    int value1 = item.getValue();
                    if (value1 > bookStore.getStock()) {
                        return new BookStoreResponse("庫存不足");
                    }
                    totalPrice += bookStore.getPrice() * value1;
                    bookStore.setStock(bookStore.getStock() - value1);
                    bookStore.setSales(bookStore.getSales() + value1);
                    NewBook book1 = new NewBook(bookStore.getBookname(), bookStore.getPrice(), bookStore.getSales(), bookStore.getStock());
                    saveList.add(book1);
                }
            }
        }
        bookStoreDao.saveAll(res);
        NewBook book1 = new NewBook();
        saveList.add(book1);
        return new BookStoreResponse("購買完成", saveList, totalPrice);
    }
}
