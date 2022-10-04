package shop.shlove.naveremail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NaverEmailApplication {

    public static void main(String[] args) {
        SpringApplication.run(NaverEmailApplication.class, args);
    }

}
