package ynu.edu.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FallBack3Controller {
    @RequestMapping("fallback3")
    public String fallback(){
        return "该服务超时，请稍后再试";
    }
}
