package ynu.edu.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FallBackController {

    @RequestMapping("fallback")
    public String fallback(){
        return "该服务产生了熔断，请稍后再试";
    }
}
