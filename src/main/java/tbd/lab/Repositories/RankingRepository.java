package tbd.lab.Repositories;
import java.util.List;
import tbd.lab.Models.Ranking;
public interface RankingRepository {
    public int countRanking();
    public List<Ranking> getAllRanking();
    public String createRanking(Ranking ranking);
    public Ranking getRanking(Integer id);
    public String updateRanking(Ranking ranking, Integer id);
    public String deleteRanking(Integer id);
}
