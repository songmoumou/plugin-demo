#
## dataway 前端访问接口
* 作用

 Dataway 是基于 DataQL 服务聚合能力，为应用提供的一个接口配置工具。使得使用者无需开发任何代码就配置一个满足需求的接口。 整个接口配置、测试、冒烟、发布。一站式都通过 Dataway 提供的 UI 界面完成。UI 会以 Jar 包方式提供并集成到应用中并和应用共享同一个 http 端口，应用无需单独为 Dataway 开辟新的管理端口。
* 参考文献

https://my.oschina.net/ta8210/blog/3234639

## monitor 系统运行监控
oshi
https://www.cnblogs.com/sundaboke/p/8493937.html

## spring-data-rest 
* 说明：
   > 使用jpa，简化增删改查，并将maper接口直接暴露到restful
* 作用


  >Spring Data REST 作为 Spring Data 项目的子集，开发者只需使用注解 @RepositoryRestResource 标记，就可以把整个 Repository 转换为
 HAL 风格的 REST 资源
* 访问路径
   
   http://localhost:8080/api/
   
   http://localhost:8080/api/user/1
* 参考文献

https://cloud.tencent.com/developer/article/1415420
https://segmentfault.com/a/1190000015972022

[jpa规则](https://blog.csdn.net/xiang__liu/article/details/80900817)


##elasticsearch学习
> 测试elasticsearch提供的高级REST客户端的API使用  
  并封装了一套通用的java操作elasticsearch代码  

参考文献：

[ElasticSearch介绍](https://www.jianshu.com/p/403c9d5b1463)

[ES快速入门](https://www.jianshu.com/p/7d687c9dba4f)

[使用Java操作Elasticsearch](https://www.jianshu.com/p/871f33c2d515)

[参考项目地址](https://github.com/luohaipeng/es-java-api)

详细操作见模块内readme

错误汇总：

[elasticsearch-head插件显示未连接](https://blog.csdn.net/qq_27868061/article/details/82963771)



##spring-es spring集成es

## ES 可视化工具
Elasticsearch-head
kibana


## solr学习


[参考代码](https://github.com/DreamsChaser/solr-demo)
https://www.cnblogs.com/wdfordream/p/11352053.html

https://www.cnblogs.com/wdfordream/p/11377161.html

问题：solr nvarchar类型放不下长文本，改为clob，需要配置
transformer="ClobTransformer" 和 clob="true"
```xml
  <document>
      <entity name="lawSolr" transformer="ClobTransformer" query="select ID,DEPT,BUSINESSTYPE,BUSINESSLAW,LAWITEM,FLOWDIAGRAM,FILEDIR from LAW_SOLR">
        <field column="ID" name="id"/>
        <field column="DEPT" name="dept"/>
        <field column="BUSINESSTYPE" name="businessType"/>
        <field column="BUSINESSLAW" name="businessLaw" clob="true"/>
        <field column="LAWITEM" name="lawItem" clob="true"/>
        <field column="FLOWDIAGRAM" name="flowDiagram"/>
        <field column="FILEDIR" name="fileDir"/>
      </entity>
  </document>
```


## db-export
将数据库字段，表结构导出到doc文件，方便编写数据库设计文档
