package tbd.lab.Repositories;

import tbd.lab.Models.Institucion;

import java.util.List;

public interface InstitucionRepository {
    public int countInstitucion();
    public List<Institucion> getAllInstitucion();
    public String createInstitucion(Institucion institucion);
    public Institucion getInstitucion(Integer id);
    public String updateInstitucion(Institucion institucion, Integer id);
    public String deleteInstitucion(Integer id);
}
