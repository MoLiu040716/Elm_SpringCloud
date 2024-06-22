package ynu.edu.controller;

import io.github.resilience4j.retry.annotation.Retry;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.User;
import ynu.edu.jwt.tokenUtil;
import ynu.edu.service.impl.loginServiceImpl;

@RestController
@RequestMapping("/userLogin")
public class LoginController {
    @Resource
    private loginServiceImpl loginService;

    @PostMapping("/login")
    @Retry(name="retry1" ,fallbackMethod = "fallbackMethod")
    public String login(@RequestBody User user){
        String id = user.getUserId();
        String passWord = user.getPassWord();
        if (loginService.login(id,passWord)!=null){
            String token = tokenUtil.token(id,passWord);
            System.out.println("运行正常");
            return token;
        }

        else
            return null;
    }

    public String fallbackMethod(User user, Throwable throwable){
        String message = "当前服务火爆，开启重试机制";
        System.out.println(message);
        return message;
    }
}
