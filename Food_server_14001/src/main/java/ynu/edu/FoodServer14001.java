package ynu.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FoodServer14001 {
    public static void main(String[] args) {
        SpringApplication.run(FoodServer14001.class,args);
    }
}
