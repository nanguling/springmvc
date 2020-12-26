03_接收请求参数-逐个接收：接受请求的参数

接受请求参数使用的处理器方法的形参
1.HttpServletRequest
2.HttpServletResponse
3.HttpSession
4.用户提交的数据

接收用户提交的参数
1.逐个接收
2.对象接收

注意：
    在提交请求参数时，get方式中文无乱码
    使用post方式中文有乱码
    需要使用过滤器处理乱码的问题

过滤器：可以自定义，也可以使用框架中提供的过滤器（CharacterEncodingFilter）

实现步骤：
1.新建web maven工程
2.加入依赖
  spring-webmvc依赖，间接的把spring的依赖都加入到项目
  jsp依赖
  servlet依赖
3.重点：在web.xml文件中注册springmvc框架的核心对象DispatherServlet
    1）DispatherServlet叫作【中央调度器】，是一个servlet，它的父类是继承HttpServlet
    2）DispatherServlet也叫做【前端控制器(front controller)】
    3）DispatherServlet负责接收用户提交的请求，调用其他的控制器对象，并把请求的处理结果显示给用户
4.创建一个发起请求的页面
5.创建一个控制器类
    1）使用@Controller注解，创建对象，放入到spring MVC容器中
    2）在类中的方法上加入@RequestMapping注解
6.创建一个作为结果的jsp，显示请求的处理结果
7.创建springMVC配置文件(和spring配置文件一样)
    1）声明组件扫描器，指定@Controller注解所在的包名
    2）声明视图解析器，帮助处理视图