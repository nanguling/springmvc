package com.mystudy.demo.contorller;

import com.mystudy.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
public class TestArgumentController {



    private static final Logger log = LoggerFactory.getLogger(TestArgumentController.class);

    @RequestMapping("/holiday/{day}")
    public Object holiday(@PathVariable String day) {
        log.debug("获取到请求路径参数："+day);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @PostMapping("/login3")
    public Object login3(@RequestParam String username,@RequestParam String passward) {
        log.debug("获取到请求路径参数:username=={},passward=={}",username,passward);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @PostMapping("/login2")
    public Object login2(@RequestParam(required = false) Integer i) {
        log.debug("获取到请求路径参数:i==" + i);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @PostMapping("/register")
    public Object register(@RequestParam String username,@RequestParam String passward,@RequestParam MultipartFile file) throws IOException {
        log.debug("获取到请求路径参数:username=={},passward=={}",username,passward);
        log.debug("头像信息，名称={}，内容={}",file.getOriginalFilename(),new String(file.getBytes()));
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @PostMapping("/pojo")
    public Object pojo(User user) {
        log.debug("获取到请求路径参数:username=={},passward=={}",user.getUsername(),user.getPassward());
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @PostMapping("/pojo1")
    public Object pojo1(String username,String passward) {
        log.debug("获取到请求路径参数:username=={},passward=={}",username,passward);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @PostMapping("/json")
    public Object json(@RequestBody User user) {
        log.debug("用户信息为{}：",user);
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }

    @RequestMapping("/file")
    public Object file(@RequestPart MultipartFile file) throws IOException {
        log.debug("头像信息，名称={}，内容={}",file.getOriginalFilename(),new String(file.getBytes()));
        Map<String,Object> map = new HashMap<>();
        map.put("ok",true);
        return map;
    }


}
