package tbd.lab.emersys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"tbd.lab.*"})
@SpringBootApplication
public class EmersysApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmersysApplication.class, args);
    }

}
