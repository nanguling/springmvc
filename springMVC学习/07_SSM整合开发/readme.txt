07_SSM整合开发：SSM整合开发

SSM：SpringMVC+Spring+MyBatis

SpringMVC：视图层，界面层，负责接受请求，显示处理结果。
Spring：业务层，管理service，dao，工具类对象。
MyBatis：持久层，访问数据库。

用户发起请求--springmvc接收--spring中的service对象--mybatis处理数据

SSM整合也叫做SSI（IBatis也就是MyBatis的前身），整合中有容器。
1.第一个容器springmvc容器，管理controller控制器对象的。
2.第二个容器spring容器，管理service和dao，工具类对象的。
我们要做的是把使用的对象交给合适的容器创建和管理。

把Controller和web开发相关对象交给springmvc容器，这些对象写在springmvc配置文件中。

把service对象，dao和工具类对象定义在spring的配置文件中，让spring来管理这些对象。

springmvc容器和spring容器是有关系的，这个关系已经确定好了。
springmvc容器时spring容器的子容器，类似java中的继承。子可以访问父的内容
在子容器中的Controller可以访问父容器中的Servic，就可以实现Controller使用Service

实现步骤：
0.使用db2020的数据库，使用student表(id，name，age)
1.新建maven的web项目
2.加入依赖
    springmvc，spring，mybatis三个框架的依赖
    jackson依赖
    mysql驱动
    druid连接池
    jsp依赖
    servlet依赖
3.写web.xml
    1）注册中央调度器DispatherServlet。创建springmvc容器对象，才能创建Controller对象；创建servlet对象接收用户请求。
    2）注册spring的监听器：ContextLoaderListener。创建spring容器对象，才能创建service，dao等对象。
    3）注册字符集过滤器，解决post请求乱码问题
4.创建包，controller，service，dao，entity
5.写sprigmvc，spring，mybatis配置文件
    1）springmvc配置文件
    2）spring配置文件
    3）mybatis配置文件
    4）数据库的属性配置文件
6.写代码，dao接口和mapper文件，service和实现类，controller，实体类
7.写jsp页面


create table student (
    id int primary key auto_increment,
    name varchar(20),
    age int
);
insert into student