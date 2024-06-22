package ynu.edu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServer16001 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer16001.class,args);
    }
}
