package com.example.bookstore;

import com.example.bookstore.entity.BookStore;
import com.example.bookstore.respository.BookStoreDao;
import com.example.bookstore.service.BookStoreService;
import com.example.bookstore.vo.BookStoreResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BookStoreTest {

    //1個response寫一個Test

    @Autowired
    private BookStoreDao bookStoreDao;

    @Autowired
    private BookStoreService bookStoreService;

    /*
    @BeforeEach
    在執行@Test之前會先執行此步驟
    @AfterEach
    在執行@Test之後執行此步驟，以上兩個方法可以用來在測試中新增刪除假資料
    @BeforeAll
    在所有程式碼開始執行之前 用來模擬請求
    @AfterAll
    在所有程式碼結束之後執行
     */

//    @Test
//    public void saleRankingTest() {
//        BookStore bookStore = new BookStore();
//        List<String> list = bookStoreDao.all();
//        for (BookStore bookStore : list) {
//            System.out.println(list);
//        }
//    }
//    @Test
//    public void byBookNameOrAuthor() {
//        List<Book> list = bookStoreDao.byBookNameOrAuthor("原");
//            System.out.println(list);
//    }

    @Test
    public void addBookInfoTest() {
        List<BookStore> list = new ArrayList<>();
        BookStore book = new BookStore("海賊王100", "1234567849101", "尾田", 120, 5,0,"少年");
        BookStore book1 = new BookStore("海賊王101", "3245456459101", "尾田", 120, 5,0,"少年");

        list.add(book);
        list.add(book1);
        BookStoreResponse response = bookStoreService.addBookInfo(list);
        assertNotNull(response);
    }

    @Test
    public void findBycategory(){
        List<BookStore> list = new ArrayList<>();

    }
}
