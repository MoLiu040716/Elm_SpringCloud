package ynu.edu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer18001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer18001.class,args);
    }
}
