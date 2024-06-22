package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BusinessServer13000 {
    public static void main(String[] args) {
        SpringApplication.run(BusinessServer13000.class,args);
    }
}
