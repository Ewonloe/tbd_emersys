package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Institucion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countInstitucion()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT COUNT(*) FROM institucion").executeScalar(Integer.class);
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Institucion> getAllInstitucion()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM institucion").executeAndFetch(Institucion.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createInstitucion(Institucion institucion)
    {
        String sql = "INSERT INTO institucion (nombre, descrip) VALUES (:insName, :insDesc)";

        try(Connection conn = sql2o.open())
        {
            conn.createQuery(sql, true)
                    .addParameter("insName", institucion.getNombre())
                    .addParameter("insDesc", institucion.getDescrip())
                    .executeUpdate();

            return "Institucion creada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institucion getInstitucion(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM institucion WHERE id = :insId")
                    .addParameter("insId", id)
                    .executeAndFetch(Institucion.class).get(0);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateInstitucion(Institucion institucion, Integer id)
    {
        String sql = "UPDATE institucion SET nombre = :insName, descrip = :insDesc WHERE id = :insId";

        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql)
                    .addParameter("insName", institucion.getNombre())
                    .addParameter("insDesc", institucion.getDescrip())
                    .addParameter("insId", id)
                    .executeUpdate();

            return "Institucion actualizada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteInstitucion(Integer id)
    {
        try(Connection conn = sql2o.open()) {

            conn.createQuery("DELETE FROM institucion WHERE id = :insId")
                    .addParameter("insId", id)
                    .executeUpdate();

            return "Institucion eliminada con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
