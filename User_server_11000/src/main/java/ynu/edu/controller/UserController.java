package ynu.edu.controller;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ynu.edu.entity.User;
import ynu.edu.service.serviceImpl.individualServiceImpl;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/userInfo")
public class UserController {
    @Resource
    private individualServiceImpl individualService;
    @PostMapping("/upload")
    @CircuitBreaker(name="backendA" ,fallbackMethod ="fallbackMethod2" )
    public String getAvatar(MultipartFile file){
        String filename = file.getOriginalFilename();
        String newName = System.currentTimeMillis() + filename.substring(filename.lastIndexOf("."));
        String path = "D:\\exam\\upload";
        File newPath = new File(path);
        if (!newPath.exists())
            newPath.mkdir();
        try {
            File newFile = new File(newPath,newName);
            file.transferTo(newFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(path+newName);
        return path+newName;
    }

    @PostMapping("/insertImg")
    @CircuitBreaker(name="backendB" ,fallbackMethod ="fallbackMethod3" )
    public void insertImg(@RequestBody User user){
        individualService.insertImg(user);
    }

    @PostMapping("/pushImg")
    @CircuitBreaker(name="backendB" ,fallbackMethod ="fallbackMethod2" )
    public String pushImg(@RequestBody User user){
        return individualService.pushImg(user);
    }

    @PostMapping("/saveIndividual")
    @CircuitBreaker(name="backendA" ,fallbackMethod ="fallbackMethod3" )
    public void saveIndividual(@RequestBody User user){
        individualService.saveIndividual(user);
    }

    @PostMapping("/pushUser")
    @CircuitBreaker(name="backendA" ,fallbackMethod ="fallbackMethod1" )
    public User pushUser(@RequestBody User user){
        System.out.println("运行正常");
        return individualService.pushUser(user);
    }

    public User fallbackMethod1(User user, Throwable throwable){
        String Message = "当前服务火爆，服务被熔断";
        System.out.println(Message);
        return  new User();
    }
    public String fallbackMethod2(User user, Throwable throwable){
        String Message = "当前服务火爆，服务被熔断";
        System.out.println(Message);
        return  Message;
    }
    public void fallbackMethod3(User user, Throwable throwable){
        String Message = "当前服务火爆，服务被熔断";
        System.out.println(Message);

    }
}
