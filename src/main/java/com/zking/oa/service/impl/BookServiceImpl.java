package com.zking.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zking.oa.mapper.BookMapper;
import com.zking.oa.model.Book;
import com.zking.oa.utile.PageBean;
import com.zking.oa.vo.BookVo;

import java.util.List;
import java.util.Map;

public class BookServiceImpl implements IBookService {

    private BookMapper bookMapper;

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }


    @Override
    public void add(Book book) {
        bookMapper.insert(book);
    }

    @Override
    public List<Book> ListBook(BookVo bookVo, PageBean pageBean) {

        if (null != pageBean && pageBean.isPagination()) {
            PageHelper.startPage(pageBean.getPage(), pageBean.getRows());
        }
        List<Book> books = bookMapper.listBook(bookVo);

        if (null != pageBean && pageBean.isPagination()) {
            PageInfo pageInfo = new PageInfo(books);
            pageBean.setTotal(pageInfo.getTotal() + "");
        }
        
        return books;

    }

    @Override
    public List<Map<String, Object>> listMap(Book book) {
        return bookMapper.listMap(book);
    }
}
