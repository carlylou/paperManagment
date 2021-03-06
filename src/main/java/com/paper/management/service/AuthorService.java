package com.paper.management.service;

import com.paper.management.entity.Author;
import com.paper.management.mapper.AuthorMapper;
import com.paper.management.mapper.PapersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Condition;

import java.io.Serializable;
import java.util.List;

/**
 * 针对作者对象进行CRUD操作.
 *
 * Created by liumengyao on 17/4/20.
 */
@Service
public class AuthorService{

    @Autowired
    AuthorMapper authorMapper;

    @Autowired
    PapersMapper papersMapper;

    public Author getByName(String authorName){
        Condition condition = new Condition(Author.class);
        condition.createCriteria().andEqualTo("authorName", authorName);
        List<Author> authors = authorMapper.selectByExample(condition);
        if(authors.size() == 0) {
            return null;
        }
        else {
            return authors.get(0);
        }
    }





}
