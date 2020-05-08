package com.song.es.spring;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author AJohn
 */
@Service
public interface TestService {
  Iterable<TestBean> findAll();

  void save(List<TestBean> list);

  void save(TestBean bean);

  List<TestBean> findByName(String text);

  List<TestBean> findByNameOrDesc(String text);
}
