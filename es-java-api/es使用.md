##基本使用
在elasticsearch的官网上提供了两种java语言的API，
一种是Java Transport Client，一种是Java REST Client。
官方推荐使用Java High Level REST Client

###类定义以及作用

config 基本配置
>* MyElasticsearchRestClient 处理客户端
>* ApplicationContextHolder 通过这个上下文环境对象得到Spring容器中的Bean

util 工具类
>* BeanUtil 工具，将类转换为map
>* RepositoryName 注解，相当于给属性赋值作用 

vo 查询实体，相当于数据库映射对象，这里列举了两个
>* ArticleVo
>* EmployeeVo

controller 测试接口
> * TestController

qo 请求接口参数封装
> * QueryObject 通用的封装请求对象
> * PageResult 请求结果分页
> * EmployeeQueryObject 继承QueryObject，自定义部分请求参数
> * ArticleQueryObject 继承QueryObject，自定义部分请求参数

repository 操作ES方法
> * IBaseRepository 封装通用的操作ES方法
> * IArticleRepository 继承IBaseRepository
> * IEmployeeRepository 继承IBaseRepository
> * BaseRepositoryImpl 实现类
> * ArticleRepositoryImpl 实现类，主要是通过注解加入参数
> * EmployeeRepositoryImpl 实现类，主要是通过注解加入参数