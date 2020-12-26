package com.mystudy.demo.contorller;

import com.mystudy.demo.model.ResponseJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @RestController:组合注解
 *  相当于@Controller和@RequestBody
 */
@RestController
@RequestMapping("/rest")
public class TestRestController {

    @RequestMapping("/1")
    public Object test() {
        ResponseJson rj = new ResponseJson();
        rj.setCode("444");
        rj.setData(new Date());
        rj.setMessage("xxxx");
        rj.setSuccess(true);
        return rj;
    }
}
