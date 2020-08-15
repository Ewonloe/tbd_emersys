package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Habilidad;

import java.util.List;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countHabilidad()
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT COUNT(*) FROM habilidad").executeScalar(Integer.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Habilidad> getAllHabilidad()
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM habilidad").executeAndFetch(Habilidad.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createHabilidad(Habilidad habilidad)
    {
        String sql = "INSERT INTO habilidad (descrip) VALUES (:habDesc)";

        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql, true)
                    .addParameter("habDesc", habilidad.getDescrip())
                    .executeUpdate();

            return "Habilidad creada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Habilidad getHabilidad(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM habilidad WHERE id = :habId")
                    .addParameter("habId", id)
                    .executeAndFetch(Habilidad.class).get(0);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateHabilidad(Habilidad habilidad, Integer id)
    {
        String sql = "UPDATE habilidad SET descrip = :habDesc WHERE id = :habId";

        try(Connection conn = sql2o.open())
        {
            conn.createQuery(sql)
                    .addParameter("habDesc", habilidad.getDescrip())
                    .addParameter("habId", id)
                    .executeUpdate();

            return "Habilidad actualizada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteHabilidad(Integer id)
    {
        try(Connection conn = sql2o.open())
        {
            conn.createQuery("DELETE FROM habilidad WHERE id = :habId")
                    .addParameter("habId", id)
                    .executeUpdate();

            return "Habilidad eliminada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}