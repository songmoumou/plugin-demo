package com.song.es.spring;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AJohn
 */
@RestController
@RequestMapping("/spring")
public class SpringESController {

  @Autowired
  TestService testService;

  @RequestMapping("findAll")
  public Iterable<TestBean> findAll() {

    return testService.findAll();
  }

  @RequestMapping("list")
  public String save() {
    List<TestBean> list = null;
    testService.save(list);

    return "success";
  }

  @RequestMapping("save")
  public void save(TestBean bean) {
    testService.save(bean);
  }

  @RequestMapping("findByName")
  public List<TestBean> findByName(String name) {
    return testService.findByName(name);
  }

  @RequestMapping("findByNameOrDesc")
  public List<TestBean> findByNameOrDesc(String text) {
    return testService.findByNameOrDesc(text);
  }

}
