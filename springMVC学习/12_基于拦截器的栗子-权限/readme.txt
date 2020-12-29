12_基于拦截器的栗子-权限：使用拦截器检查登陆的用户是不是能访问系统

实现步骤：
1.新建maven web项目
2.修改web.xml注册中央调度器
3.新建index.jsp发起请求
4.创建MyController处理请求
5.创建show.jsp
6.创建一个login.jsp模拟登录（把用户信息放入session中）
  创建一个logout.jsp模拟退出系统（从session中删除数据）
7.创建拦截器，从session中获取登陆数据，验证能否访问系统
8.创建一个验证的jsp，如果验证失败，给出提示
9.创建springmvc配置文件
  声明组件扫描器
  声明拦截器