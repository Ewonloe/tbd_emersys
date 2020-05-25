package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Emergencia;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEmergencia()
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT COUNT(*) FROM emergencia").executeScalar(Integer.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Emergencia> getAllEmergencia()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM emergencia").executeAndFetch(Emergencia.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createEmergencia(Emergencia emergencia)
    {
        String sql = "INSERT INTO emergencia (nombre, descrip, finicio, ffin, id_institucion) VALUES (:emerName, :emerDesc, :emerFinicio, :emerFfin, :emerId_ins)";

        try(Connection conn = sql2o.open())
        {
            conn.createQuery(sql, true)
                    .addParameter("emerName", emergencia.getNombre())
                    .addParameter("emerDesc", emergencia.getDescrip())
                    .addParameter("emerFinicio", emergencia.getFinicio())
                    .addParameter("emerFfin", emergencia.getFfin())
                    .addParameter("emerId_ins", emergencia.getId_institucion())
                    .executeUpdate().getKey();

            return "Emergencia creada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Emergencia getEmergencia(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM emergencia WHERE id = :emerId")
                    .addParameter("emerId", id)
                    .executeAndFetch(Emergencia.class).get(0);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateEmergencia(Emergencia emergencia, Integer id) {
        String sql = "UPDATE emergencia SET nombre = :emerName, descrip = :emerDesc, finicio = :emerFinicio, ffin = :emerFfin, id_institucion = :emerId_ins WHERE id = :emerId";

        try (Connection conn = sql2o.open()) {
                    conn.createQuery(sql)
                    .addParameter("emerName", emergencia.getNombre())
                    .addParameter("emerDesc", emergencia.getDescrip())
                    .addParameter("emerFinicio", emergencia.getFinicio())
                    .addParameter("emerFfin", emergencia.getFfin())
                    .addParameter("emerId_ins", emergencia.getId_institucion())
                    .addParameter("emerId", id)
                    .executeUpdate().getKey();

            return "Emergencia actualizada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteEmergencia(Integer id)
    {
        try(Connection conn = sql2o.open())
        {
            conn.createQuery("DELETE FROM emergencia WHERE id = :emerId")
                    .addParameter("emerId", id)
                    .executeUpdate();

            return "Emergencia eliminada con exito";
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
