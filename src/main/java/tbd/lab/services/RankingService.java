package tbd.lab.services;
import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Ranking;
import tbd.lab.Repositories.RankingRepository;

import java.util.List;

@CrossOrigin
@RestController
public class RankingService {
    private final RankingRepository rankRepo;
    RankingService(RankingRepository rankRepo)
    {
        this.rankRepo = rankRepo;
    }

    @GetMapping("/ranking/all")
    public List<Ranking> getAllRanking()
    {
        return rankRepo.getAllRanking();
    }

    @GetMapping("/ranking/count")
    public String countRanking()
    {
        int count = rankRepo.countRanking();
        return String.format("Hay %s rankings", count);
    }

    @PostMapping("/ranking/add")
    @ResponseBody
    public String createRanking(@RequestBody Ranking ranking)
    {
        return rankRepo.createRanking(ranking);
    }

    @GetMapping("/ranking/{id}")
    public Ranking getRanking(@PathVariable(value = "id") Integer id)
    {
        return rankRepo.getRanking(id);
    }

    @PutMapping("/ranking/update/{id}")
    @ResponseBody
    public String updateRanking(@RequestBody Ranking ranking, @PathVariable(value = "id") Integer id)
    {
        return rankRepo.updateRanking(ranking, id);
    }

    @DeleteMapping("/ranking/delete/{id}")
    public String deleteRanking(@PathVariable(value = "id") Integer id)
    {
        return rankRepo.deleteRanking(id);
    }
}
