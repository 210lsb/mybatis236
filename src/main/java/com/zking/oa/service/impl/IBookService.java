package com.zking.oa.service.impl;

import com.zking.oa.model.Book;
import com.zking.oa.utile.PageBean;
import com.zking.oa.vo.BookVo;

import java.util.List;
import java.util.Map;

public interface IBookService {

    void add(Book book);

    List<Book> ListBook(BookVo bookVo, PageBean pageBean);

    List<Map<String,Object>> listMap(Book book);

}
