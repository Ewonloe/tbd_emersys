package tbd.lab.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {

    @GetMapping("/honk")
    public String honkWorld()
    {
        return "Honk";
    }
}
