package ynu.edu.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FallBack2Controller {
    @RequestMapping("fallback2")
    public String fallback(){
        return "服务被限流";
    }
}
