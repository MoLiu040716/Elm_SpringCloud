package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LoginServer12000 {
    public static void main(String[] args) {
        SpringApplication.run(LoginServer12000.class,args);
    }
}
