package tbd.lab.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tbd.lab.Repositories.GooseRepository;

@RestController
public class GooseService {
    private final GooseRepository gooseRepository;
    GooseService(GooseRepository gooseRepository){
        this.gooseRepository = gooseRepository;
    }

    @GetMapping("/geese/count")
    public String countGoose(){
        int total = gooseRepository.countGoose();
        return String.format("Honk %s honks, honk", total);
    }

}
