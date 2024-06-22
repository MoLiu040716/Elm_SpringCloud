package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class UserServer11000 {
    public static void main(String[] args) {
        SpringApplication.run(UserServer11000.class,args);
    }
}
