package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Voluntario;

import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countVoluntario()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT COUNT(*) FROM voluntario").executeScalar(Integer.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }

    }

    @Override
    public List<Voluntario> getAllVoluntario()
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * FROM voluntario").executeAndFetch(Voluntario.class);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createVoluntario(Voluntario voluntario)
    {
        String sql = "INSERT INTO voluntario (nombre, fnacimiento) VALUES (:volName, :volFnac)";
        try (Connection conn = sql2o.open())
        {
            //conn.getJdbcConnection().setAutoCommit(false);
            conn.createQuery(sql, true)
                    .addParameter("volName", voluntario.getNombre())
                    .addParameter("volFnac", voluntario.getFnacimiento())
                    .executeUpdate();

            return "Voluntario creado con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Voluntario getVoluntario(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * from voluntario WHERE id = :volId")
                    .addParameter("volId", id)
                    .executeAndFetch(Voluntario.class).get(0);
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // JSON debe incluir todos los atributos, no solo los que se piensan cambiar.
    @Override
    public String updateVoluntario(Voluntario voluntario, Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            conn.createQuery("UPDATE voluntario SET nombre = :volNombre, fnacimiento = :volFnac WHERE id = :volId")
                    .addParameter("volNombre", voluntario.getNombre())
                    .addParameter("volFnac", voluntario.getFnacimiento())
                    .addParameter("volId", id)
                    .executeUpdate();

            return "Voluntario actualizado con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteVoluntario(Integer id)
    {
        try (Connection conn = sql2o.open())
        {
            conn.createQuery("DELETE FROM voluntario WHERE id = :volId")
                    .addParameter("volId", id)
                    .executeUpdate();

            return "Voluntario eliminado con exito";
        }

        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario> getRankingBetween(Float minValue, Float maxValue)
    {
        try(Connection conn = sql2o.open())
        {
            return conn.createQuery("SELECT * " +
                    "FROM voluntario " +
                    "WHERE id IN "+
                    "(SELECT id_voluntario " +
                    "FROM ranking " +
                    "WHERE puntaje BETWEEN :minValue AND :maxValue)")
                    .addParameter("minValue", minValue)
                    .addParameter("maxValue", maxValue)
                    .addColumnMapping("id_voluntario", "idVoluntario")
                    .executeAndFetch(Voluntario.class);
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
