package edu.soft2.controller;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class IndexController {
    //1.接收处理器
    //2.调用业务逻辑
    //3.页面跳转
    @RequestMapping(value = "/sayHello")
    public String sayHello(){
        System.out.println("Hello SpringMVC");
        //url:/WEB-INF/pages/xxx.jsp
        return "success";//页面跳转(视图解析器的前后缀拼接出URL)
        //默认用的forward转发的方式跳转
    }
    @RequestMapping("/sayHi")
    public String sayHi(){
        System.out.println("-------sayHi()--------");
        return "Hi";
    }
}
