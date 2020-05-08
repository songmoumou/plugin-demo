package com.song.solr.demo;

import lombok.Data;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "book_core")
@Data
public class Book {

  @Id
  @Field
  private String id;

  @Field
  private String description;


}