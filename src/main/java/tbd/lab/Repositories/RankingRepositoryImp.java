package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Ranking;
import tbd.lab.Models.Voluntario;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countRanking()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT COUNT(*) FROM ranking").executeScalar(Integer.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Ranking> getAllRanking()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM ranking").executeAndFetch(Ranking.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createRanking(Ranking ranking)
    {
        String sql = "INSERT INTO ranking (puntaje,flg_invitado,flg_participa,id_voluntario,id_tarea) VALUES (:rankPuntaje,:rankFlg_invitado,:rankFlg_participa,:rankId_voluntario,:rankId_tarea)";
        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql, true)
                    .addParameter("rankPuntaje", ranking.getPuntaje())
                    .addParameter("rankFlg_invitado", ranking.getFlg_invitado())
                    .addParameter("rankFlg_participa", ranking.getFlg_participa())
                    .addParameter("rankId_voluntario", ranking.getId_voluntario())
                    .addParameter("rankId_tarea", ranking.getId_tarea())
                    .executeUpdate();

            return "Ranking creado con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking getRanking(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM ranking WHERE id = :rankId")
                    .addParameter("rankId", id)
                    .executeAndFetch(Ranking.class).get(0);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateRanking(Ranking ranking, Integer id)
    {
        String sql = "UPDATE ranking SET puntaje= :rankPuntaje,flg_invitado= :rankFlg_invitado,flg_participa=:rankFlg_participa,id_voluntario=:rankId_voluntario,id_tarea=:rankId_tarea WHERE id = :rankId";
        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql)
                    .addParameter("rankPuntaje",ranking.getPuntaje())
                    .addParameter("rankFlg_invitado",ranking.getFlg_invitado())
                    .addParameter("rankFlg_participa",ranking.getFlg_participa())
                    .addParameter("rankId_voluntario",ranking.getId_voluntario())
                    .addParameter("rankId_tarea",ranking.getId_tarea())
                    .addParameter("rankId", id)
                    .executeUpdate();

            return "Ranking actualizado con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteRanking(Integer id)
    {
        try(Connection conn = sql2o.open())
        {
            conn.createQuery("DELETE FROM ranking WHERE id = :rankId")
                    .addParameter("rankId", id)
                    .executeUpdate();

            return "Ranking eliminado con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
