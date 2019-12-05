package com.zking.oa.mapper;

import com.zking.oa.model.Book;
import com.zking.oa.vo.BookVo;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> listBook(BookVo bookVo);

    List<Map<String,Object>> listMap(Book book);
}