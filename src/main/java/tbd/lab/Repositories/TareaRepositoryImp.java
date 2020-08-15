package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Habilidad;
import tbd.lab.Models.Tarea;

import java.net.Inet4Address;
import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countTarea()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT COUNT(*) FROM tarea").executeScalar(Integer.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Tarea> getAllTarea()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM tarea").executeAndFetch(Tarea.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createTarea(Tarea tarea)
    {
        String sql = "INSERT INTO tarea (nombre, descrip, cant_vol_requeridos, cant_vol_inscritos, finicio, ffin, id_emergencia, id_estado) VALUES (:tarName, :tarDesc, :tarCvr, :tarCvi, :tarFini, :tarFfin, :tarId_emer, :tarId_est)";
        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql, true)
                    .addParameter("tarName", tarea.getNombre())
                    .addParameter("tarDesc", tarea.getDescrip())
                    .addParameter("tarCvr", tarea.getCant_vol_requeridos())
                    .addParameter("tarCvi", tarea.getCant_vol_inscritos())
                    .addParameter("tarFini", tarea.getFinicio())
                    .addParameter("tarFfin", tarea.getFfin())
                    .addParameter("tarId_emer", tarea.getId_emergencia())
                    .addParameter("tarId_est", tarea.getId_estado())
                    .executeUpdate();

            return "Tarea creada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea getTarea(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM tarea WHERE id = :tarId")
                    .addParameter("tarId", id)
                    .executeAndFetch(Tarea.class).get(0);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateTarea(Tarea tarea, Integer id)
    {
        String sql = "UPDATE tarea SET nombre = :tarName, descrip = :tarDesc, cant_vol_requeridos = :tarCvr, cant_vol_inscritos = :tarCvi, finicio = :tarFini, ffin = :tarFfin, id_emergencia = :tarId_emer, id_estado = :tarId_est WHERE id = :tarId";
        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql)
                    .addParameter("tarName", tarea.getNombre())
                    .addParameter("tarDesc", tarea.getDescrip())
                    .addParameter("tarCvr", tarea.getCant_vol_requeridos())
                    .addParameter("tarCvi", tarea.getCant_vol_inscritos())
                    .addParameter("tarFini", tarea.getFinicio())
                    .addParameter("tarFfin", tarea.getFfin())
                    .addParameter("tarId_emer", tarea.getId_emergencia())
                    .addParameter("tarId_est", tarea.getId_estado())
                    .addParameter("tarId", id)
                    .executeUpdate();

            return "Tarea actualizada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteTarea(Integer id)
    {
        try(Connection conn = sql2o.open())
        {
            conn.createQuery("DELETE FROM tarea WHERE id = :tarId")
                    .addParameter("tarId", id)
                    .executeUpdate();

            return "Tarea eliminada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Habilidad> getHabilidades(Integer id)
    {
        String sql = "SELECT * FROM habilidad WHERE id IN " +
                "(SELECT id_habilidad FROM eme_habilidad WHERE id IN " +
                "(SELECT id_emehab FROM tarea_habilidad WHERE id_tarea = :id))";

        try (Connection conn = sql2o.open())
        {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Habilidad.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Habilidad> getMissingHabilidades(Integer id)
    {
        String sql = "SELECT * FROM habilidad WHERE id NOT IN " +
                "(SELECT id_habilidad FROM eme_habilidad WHERE id IN " +
                "(SELECT id_emehab FROM tarea_habilidad WHERE id_tarea = :id))";

        try (Connection conn = sql2o.open())
        {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Habilidad.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
