package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Emergencia;
import tbd.lab.Models.Tarea_voluntario;

import java.util.List;

@Repository
public class Tarea_voluntarioRepositoryImp implements Tarea_voluntarioRepository
{
    @Autowired
    private Sql2o sql2o;

    @Override
    public int countTarea_voluntario()
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT COUNT(*) FROM tarea_voluntario").executeScalar(Integer.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Tarea_voluntario> getAllTarea_voluntario()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM tarea_voluntario").executeAndFetch(Tarea_voluntario.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createTarea_voluntario(Tarea_voluntario tarea_voluntario)
    {
        String sql = "INSERT INTO tarea_voluntario (id_voluntario, id_tarea, flg_accepted) VALUES (:vol_id, :tar_id, :flg_acc)";
        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql, true)
                    .addParameter("vol_id", tarea_voluntario.getId_voluntario())
                    .addParameter("tar_id", tarea_voluntario.getId_tarea())
                    .addParameter("flg_acc", tarea_voluntario.getFlg_accepted())
                    .executeUpdate();

            return "Tarea_voluntario creada con exito.";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea_voluntario getTarea_voluntario(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM tarea_voluntario WHERE id = :tarea_volId")
                    .addParameter("tarea_volId", id)
                    .executeAndFetch(Tarea_voluntario.class).get(0);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateTarea_voluntario(Tarea_voluntario tarea_voluntario, Integer id)
    {
        String sql = "UPDATE tarea_voluntario SET id_voluntario = :vol_id, id_tarea = :tar_id, flg_accepted = :flg_acc";

        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql)
                    .addParameter("vol_id", tarea_voluntario.getId_voluntario())
                    .addParameter("tar_id", tarea_voluntario.getId_tarea())
                    .addParameter("flg_acc", tarea_voluntario.getFlg_accepted())
                    .executeUpdate();

            return "Tarea_voluntario actualizada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteTarea_voluntario(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            conn.createQuery("DELETE FROM tarea_voluntario WHERE id = :tar_volId")
                    .addParameter("tar_volId", id)
                    .executeUpdate();

            return "Tarea_voluntario eliminada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
