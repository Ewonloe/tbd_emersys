package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Estado;

import java.util.List;

@Repository
public class EstadoRepositoryImp implements EstadoRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEstado()
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT COUNT(*) FROM estado").executeScalar(Integer.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Estado> getAllEstado()
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM estado").executeAndFetch(Estado.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createEstado(Estado estado)
    {
        String sql = "INSERT INTO estado (descrip) VALUES (:estDesc)";

        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql, true)
                    .addParameter("estDesc", estado.getDescrip())
                    .executeUpdate();

            return "Estado creado con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Estado getEstado(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM estado WHERE id = :estId")
                    .addParameter("estId", id)
                    .executeAndFetch(Estado.class).get(0);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateEstado(Estado estado, Integer id)
    {
        String sql = "UPDATE estado SET descrip = :estDesc WHERE id = :estId";

        try(Connection conn = sql2o.open())
        {
            conn.createQuery(sql)
                    .addParameter("estDesc", estado.getDescrip())
                    .addParameter("estId", id)
                    .executeUpdate();

            return "Estado actualizado con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteEstado(Integer id)
    {
        try(Connection conn = sql2o.open())
        {
            conn.createQuery("DELETE FROM estado WHERE id = :estId")
                    .addParameter("estId", id)
                    .executeUpdate();

            return "Estado eliminado con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
