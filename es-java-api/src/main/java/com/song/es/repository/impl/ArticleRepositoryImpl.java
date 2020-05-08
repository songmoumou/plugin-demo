package com.song.es.repository.impl;


import com.song.es.repository.IArticleRepository;
import com.song.es.util.RepositoryName;
import com.song.es.vo.ArticleVo;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ArticleRepositoryImpl extends BaseRepositoryImpl<ArticleVo> implements IArticleRepository {

    //索引
    @RepositoryName("articles-1")
    protected String index;

    //类型
    @RepositoryName("article")
    protected String type;


    /**
     * 写一些特殊的方法
     */
}







