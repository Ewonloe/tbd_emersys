package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Tarea_habilidad;

import java.util.List;

@Repository
public class Tarea_habilidadRepositoryImp implements Tarea_habilidadRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countTarea_habilidad()
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT COUNT(*) FROM tarea_habilidad").executeScalar(Integer.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }


    @Override
    public List<Tarea_habilidad> getAllTarea_habilidad()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM tarea_habilidad").executeAndFetch(Tarea_habilidad.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String createTarea_habilidad(Tarea_habilidad tarea_habilidad)
    {
        String sql = "INSERT INTO tarea_habilidad (id_habilidad, id_tarea) VALUES (:hab_id, :tar_id)";
        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql, true)
                    .addParameter("hab_id", tarea_habilidad.getId_habilidad())
                    .addParameter("tar_id", tarea_habilidad.getId_tarea())
                    .executeUpdate();

            return "Tarea_habilidad creada con exito.";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Tarea_habilidad getTarea_habilidad(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM tarea_habilidad WHERE id = :tarea_habId")
                    .addParameter("tarea_habId", id)
                    .executeAndFetch(Tarea_habilidad.class).get(0);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String updateTarea_habilidad(Tarea_habilidad tarea_habilidad, Integer id)
    {
        String sql = "UPDATE tarea_voluntario SET id_habilidad = :hab_id, id_tarea = :tar_id";

        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql)
                    .addParameter("hab_id", tarea_habilidad.getId_habilidad())
                    .addParameter("tar_id", tarea_habilidad.getId_tarea())
                    .executeUpdate();

            return "Tarea_habilidad actualizada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String deleteTarea_habilidad(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            conn.createQuery("DELETE FROM tarea_habilidad WHERE id = :tar_habId")
                    .addParameter("tar_habId", id)
                    .executeUpdate();

            return "Tarea_habilidad eliminada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
