package com.example.bookstore;

import com.example.bookstore.entity.BookStore;
import com.example.bookstore.respository.BookStoreDao;
import com.example.bookstore.service.BookStoreService;
import com.example.bookstore.vo.Book;
import com.example.bookstore.vo.BookStoreRequest;
import com.example.bookstore.vo.BookStoreResponse;
import com.example.bookstore.vo.NewBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.*;


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
        BookStore book = new BookStore("海賊王102", "1245876325489", "尾田", 120, 5, 0, "少年");
        BookStore book1 = new BookStore("海賊王103", "5598857757751", "尾田", 120, 5, 0, "少年");

        list.add(book);
        list.add(book1);
        BookStoreResponse response = bookStoreService.addBookInfo(list);
        List<BookStore> responselist = response.getBookSaleList();
        Assert.isTrue(responselist != null, "新增書籍錯誤!");
    }

    @Test
    public void findBycategory() {
        BookStoreRequest request = new BookStoreRequest();
        request.setCategory("小孩");
        BookStoreResponse response = bookStoreService.findBycategory(request);
        List<NewBook> responselist = response.getBookList();
        Assert.isTrue(responselist != null, "查詢書籍失敗");
    }

    @Test
    public void findByBookNameOrAuthor() {
        BookStoreRequest request = new BookStoreRequest();
        request.setCustomers("書籍商");
        request.setAuthor("");
        request.setBookname("海賊王");
        BookStoreResponse response = bookStoreService.findByBookNameOrAuthor(request);
        Book res = response.getBook();
        Assert.isTrue(res != null, "查詢書籍失敗");
    }

    @Test
    public void updateBookInfo() {
        BookStoreRequest request = new BookStoreRequest();
        request.setBookname("海賊王101");
        request.setPrice(125);
        request.setStock(7);
        request.setCategory("少年");
        BookStoreResponse response = bookStoreService.updateBookInfo(request);
        Book res = response.getBook();
        Assert.isTrue(res != null, "更新失敗");
    }

    @Test
    public void orderBook() {
        Map<String, Integer> finalOrderMap = new HashMap<>();
        finalOrderMap.put("海王", -2);
        BookStoreResponse response = bookStoreService.orderBook(finalOrderMap);
        Book res = response.getBook();
        Assert.isTrue(res != null, "購買失敗");
    }

    @Test
    public void stringJoinTest() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        System.out.println(list.toString());
        String str = String.join(",", list);
        System.out.println(str);
        List<String> list2 = new ArrayList<>(Arrays.asList("c", "d", "e"));
        list.addAll(list2);
        Set<String> set = new HashSet<>(list);
        System.out.println(set.toString());
        String str2 = String.join(",", set);
        System.out.println(str2);
        //-----------------------
        String[] ary = str2.split(",");
        List<String> list3 = new ArrayList<>(Arrays.asList("f", "g", "h"));
        List<String> list4 = new ArrayList<>(Arrays.asList(ary));
        list4.addAll(list3);
        System.out.println(list4);
    }

    @Test
    public void test(){
        Map<String, Integer> orderMap = new HashMap<>();
        orderMap.put("1",1);
        orderMap.put("5",2);
        orderMap.put("3",3);
        List<String> newList = new ArrayList<>(orderMap.keySet());
        System.out.println(newList);
    }
}
