04_控制器方法的返回值：处理器方法的返回值表示请求的处理结果

1.ModelAndView：有数据和视图，对视图执行forward。
2.String：表示视图，可以是逻辑名称，也可以是完整视图路径
3.void：不能表示数据，也不能表示试图。
        在处理ajax的时候，是可以使用void返回值。通过响应对象输出数据，响应ajax请求。
        ajax请求服务器端返回的就是数据，和视图无关。
4.Object：例如String，Integer，List，Student等等都是对象。
          对象有属性，属性就是数据。所以返回Object表示数据，和视图无关。
          可以使用对象表示的数据，响应ajax请求。

现在做ajax，主要使用json数据格式。实现步骤：
    1.加入处理json的工具库的依赖，springmvc默认使用jackson。
    2.在springmvc的配置文件中加入<mvc:annotation-driven>注解驱动。
        json = om.writeValueAsString(student);
    3.在处理器方法的上面加入@ResponseBody注解
        //将json字符串写入响应体返回给前端
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();

springmvc处理器方法返回Object，可以转为json字符串返回前端，响应ajax请求的内部原理：
    1.<mvc:annotation-driven> 注解驱动。
      注解驱动实现的功能是：完成java对象到json，xml，text，二进制等数据格式的转换。

      <mvc:annotation-driven>在加入到springmvc配置文件后，会自动创建HttpMessageConverter接口的
      7个实现类对象，包括 MappingJackson2HttpMessageConverter（使用jackson工具库中的ObjectMapper实现Java对象转为json字符串）

      HttpMessageConverter接口：【消息转换器】。
      功能：定义了java对象转为json，xml等数据格式的方法。
           这个接口有很多的实现类，这些实现类完成了java对象到json等数据格式的转换。

      下面的两个方法是控制器类把结果输出给浏览器时使用的：
      boolean canWrite(Class<?> var1, @Nullable MediaType var2);
      void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3) throws IOException, HttpMessageNotWritableException;

      1）canWrite：检查处理器方法的返回值能不能转为var2表示的数据格式。如果可以返回true。
         MediaType；表示数据格式，例如json，xml等等。
      2）write：把处理器方法的返回值对象调用jackson中ObjectMapper转为json字符串
         json = om.writeValueAsString(student);

    2.@ResponseBody注解
        放在处理器方法的上面，通过响应对象将处理结果写入响应体返回给前端。