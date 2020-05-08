package com.song.es.repository.impl;



import com.song.es.repository.IEmployeeRepository;
import com.song.es.util.RepositoryName;
import com.song.es.vo.EmployeeVo;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepositoryImpl extends BaseRepositoryImpl<EmployeeVo> implements IEmployeeRepository {
    //索引
    @RepositoryName("user")
    protected String index;

    //类型
    @RepositoryName("doc")
    protected String type;

    /**
     * 写一些特殊的方法
     */

}
