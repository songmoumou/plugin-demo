package com.song.solr.demo;

import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * @author wangdi9
 * @date 2019/8/16 11:16
 */
public interface BookSolrService extends SolrService<Book> {

}
