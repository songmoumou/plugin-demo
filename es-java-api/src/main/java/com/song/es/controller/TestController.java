package com.song.es.controller;


import com.song.es.qo.EmployeeQueryObject;
import com.song.es.qo.PageResult;
import com.song.es.qo.QueryObject;
import com.song.es.repository.IEmployeeRepository;
import com.song.es.vo.EmployeeVo;

import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author AJohn
 */
@RestController
public class TestController {
  @Autowired
  IEmployeeRepository employeeRepository;


  @RequestMapping("/search")
  public void search() throws Exception {

    EmployeeQueryObject qo=new EmployeeQueryObject();
    qo.setKeyword("dfdf");
    PageResult<EmployeeVo> search = employeeRepository.search(qo);
    //List<EmployeeVo> search = employeeRepository.getAll();
    System.out.println(search);
  }
  @RequestMapping("/search2")
  public void search2() throws Exception {


  }

  @RequestMapping("/insert")
  public void insert() throws Exception {

    EmployeeVo employeeVo=new EmployeeVo();
    employeeVo.setAbout("kkkkkkkkkkkkk");
    employeeVo.setAge(1212);
    employeeVo.setId(335L);
    employeeVo.setName("我的mingceng");
     employeeRepository.insertOrUpdate(employeeVo);
    //List<EmployeeVo> search = employeeRepository.getAll();
    System.out.println();
  }
  @RequestMapping("/get")
  public void get() throws Exception {
    EmployeeVo employeeVo1 = employeeRepository.get(333L);
    System.out.println();
  }

}
