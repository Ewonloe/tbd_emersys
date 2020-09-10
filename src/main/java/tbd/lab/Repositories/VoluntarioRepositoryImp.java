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
            return conn.createQuery("SELECT id, nombre, fnacimiento, st_x(st_astext(ubicacion)) AS longitud, st_y(st_astext(ubicacion)) AS latitud FROM voluntario").executeAndFetch(Voluntario.class);
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
        String sql = "INSERT INTO voluntario (nombre, fnacimiento, ubicacion) VALUES (:volName, :volFnac, ST_GeomFromText(:volUbi, 4326))";
        String ubi = "POINT("+voluntario.getLongitud()+" "+voluntario.getLatitud()+")";

        try (Connection conn = sql2o.open())
        {
            conn.createQuery(sql, true)
                    .addParameter("volName", voluntario.getNombre())
                    .addParameter("volFnac", voluntario.getFnacimiento())
                    .addParameter("volUbi", ubi)
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
            return conn.createQuery("SELECT id, nombre, fnacimiento, st_x(st_astext(ubicacion)) AS longitud, st_y(st_astext(ubicacion)) AS latitud FROM voluntario WHERE id = :volId")
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
        String ubi = "POINT("+voluntario.getLongitud()+" "+voluntario.getLatitud()+")";
        try (Connection conn = sql2o.open())
        {
            conn.createQuery("UPDATE voluntario SET nombre = :volNombre, fnacimiento = :volFnac, ubicacion = ST_GeomFromText(:volUbi, 4326) WHERE id = :volId")
                    .addParameter("volNombre", voluntario.getNombre())
                    .addParameter("volFnac", voluntario.getFnacimiento())
                    .addParameter("volUbi", ubi)
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

    @Override
    public List<Voluntario> getVolWithName(String name){
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT *" +
                                                "FROM voluntario" +
                                                "WHERE nombre = :name")
                                    .addParameter("name", name)
                                    .executeAndFetch(Voluntario.class);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Voluntario> getAllVoluntarioInArea(Integer cod_reg)
    {
        try(Connection conn = sql2o.open())
        {
            String sql = "SELECT id, nombre, fnacimiento, st_x(st_astext(ubicacion)) AS longitud, st_y(st_astext(ubicacion)) AS latitud " +
                    "FROM voluntario as v " +
                    "INNER JOIN division_regional as dr " +
                    "ON ST_WITHIN(v.ubicacion, dr.geom) " +
                    "WHERE dr.cod_regi = :cod_reg";

            return conn.createQuery(sql)
                    .addParameter("cod_reg", cod_reg)
                    .executeAndFetch(Voluntario.class);
        }

        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
