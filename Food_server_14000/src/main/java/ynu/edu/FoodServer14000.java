package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FoodServer14000 {
    public static void main(String[] args) {
        SpringApplication.run(FoodServer14000.class,args);
    }
}
