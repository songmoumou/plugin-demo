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
