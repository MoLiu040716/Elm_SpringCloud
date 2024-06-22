package ynu.edu.controller;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.User;
import ynu.edu.service.impl.registerServiceImpl;

@RestController
@RequestMapping("/userLogin")
public class RegisterController {
    @Resource
    private registerServiceImpl registerService;
    @PostMapping("/register")
    public String register(@RequestBody User user){
        if (registerService.selectUser(user.getUserId()) ==null){

            registerService.insertUser(user);
            return "注册成功";
        }
        else
            return "用户已注册";
    }

}
