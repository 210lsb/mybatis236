package com.zking.oa.service.impl;

import com.zking.oa.mapper.BookMapper;
import com.zking.oa.model.Book;
import com.zking.oa.utile.MybatisSessionFactoryUtils;
import com.zking.oa.utile.PageBean;
import com.zking.oa.vo.BookVo;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BookServiceImplTest {

    private SqlSession sqlSession;

    private  IBookService bookService;

    private Book book;

    @Before
    public void setUp() throws Exception {
        sqlSession = MybatisSessionFactoryUtils.openSession();

        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        BookServiceImpl bookServiceImpl = new BookServiceImpl();

        bookServiceImpl.setBookMapper(mapper);

        this.bookService = bookServiceImpl;

        book = new Book();
    }

    @After
    public void tearDown() throws Exception {

        sqlSession.commit();

    }

    @Test
    public void add() {
        book.setBookName("煞笔东西");
        book.setPrice(22f);
        bookService.add(book);
    }

    @Test
    public void listBook() {
        BookVo bookVo = new BookVo();
//        bookVo.setBookName("三");
        bookVo.setMin(2f);
        bookVo.setMax(50f);

        PageBean pageBean = new PageBean();

        pageBean.setPage(1);
        pageBean.setRows(4);
        List<Book> books = bookService.ListBook(bookVo,pageBean);
        for (Book book1:books){
            System.out.println(book1);
        }
    }

    @Test
    public void listMap() {
        List<Map<String, Object>> maps = bookService.listMap(book);
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }
}