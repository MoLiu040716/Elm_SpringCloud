package ynu.edu.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FallBack4Controller {
    @RequestMapping("fallback4")
    public String fallback(){
        return "该服务开启重试机制";
    }
}
