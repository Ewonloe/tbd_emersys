package tbd.lab.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import tbd.lab.Models.Eme_habilidad;

import java.util.List;

@Repository
public class Eme_habilidadRepositoryImp implements Eme_habilidadRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public int countEme_habilidad() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT COUNT(*) FROM eme_habilidad").executeScalar(Integer.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Eme_habilidad> getAllEme_habilidad() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM eme_habilidad").executeAndFetch(Eme_habilidad.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String createEme_habilidad(Eme_habilidad eme_habilidad) {
        String sql = "INSERT INTO eme_habilidad (id_emergencia, id_habilidad) VALUES (:idEme, :idHab)";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql, true)
                    .addParameter("idEme", eme_habilidad.getId_emergencia())
                    .addParameter("idHab", eme_habilidad.getId_habilidad())
                    .executeUpdate();

            return "Eme_habilidad creado con exito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Eme_habilidad getEme_habilidad(Integer id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM eme_habilidad WHERE id = :estId")
                    .addParameter("estId", id)
                    .executeAndFetch(Eme_habilidad.class).get(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String updateEme_habilidad(Eme_habilidad eme_habilidad, Integer id) {
        String sql = "UPDATE eme_habilidad SET id_emergencia = :idEme, id_habilidad = :idHab WHERE id = :eme_habId";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("idEme", eme_habilidad.getId_emergencia())
                    .addParameter("idHab", eme_habilidad.getId_habilidad())
                    .addParameter("eme_habId", id)
                    .executeUpdate();

            return "Eme_habilidad actualizado con exito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteEme_habilidad(Integer id) {
        try (Connection conn = sql2o.open()) {
            conn.createQuery("DELETE FROM eme_habilidad WHERE id = :eme_habId")
                    .addParameter("eme_habId", id)
                    .executeUpdate();

            return "Eme_habilidad eliminado con exito";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
