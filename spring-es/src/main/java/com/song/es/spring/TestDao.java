package com.song.es.spring;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


/**

 * 继承CRUD，第一个泛型是实体类类型，第二个泛型是id的类型
 */
public interface TestDao extends CrudRepository<TestBean, Long> {
  List<TestBean> findByName(String name);

  List<TestBean> findByNameOrDesc(String name,String desc);
}
