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
    public Institucion createInstitucion(Institucion institucion)
    {
        String sql = "INSERT INTO institucion (nombre, descrip) VALUES (:insName, :insDesc)";

        try(Connection conn = sql2o.open())
        {
            BigDecimal insertedID = (BigDecimal) conn.createQuery(sql, true)
                    .addParameter("insName", institucion.getNombre())
                    .addParameter("insDesc", institucion.getDescrip())
                    .executeUpdate().getKey();

            institucion.setId(insertedID);
            return institucion;
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
    public Institucion updateInstitucion(Institucion institucion, Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            BigDecimal insertedId = (BigDecimal) conn.createQuery("UPDATE institucion SET nombre = :insName, descrip = :insDesc WHERE id = :insId")
                    .addParameter("insName", institucion.getNombre())
                    .addParameter("insDesc", institucion.getDescrip())
                    .addParameter("insId", id)
                    .executeUpdate().getKey();

            institucion.setId(insertedId);
            return institucion;
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteInstitucion(Integer id)
    {
        try(Connection conn = sql2o.open()) {

            conn.createQuery("DELETE FROM institucion WHERE id = :insId")
                    .addParameter("insId", id)
                    .executeUpdate();
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
