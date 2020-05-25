package tbd.lab.Repositories;

import tbd.lab.Models.Institucion;

import java.util.List;

public interface InstitucionRepository {
    public int countInstitucion();
    public List<Institucion> getAllInstitucion();
    public Institucion createInstitucion(Institucion institucion);
    public Institucion getInstitucion(Integer id);
    public Institucion updateInstitucion(Institucion institucion, Integer id);
    public void deleteInstitucion(Integer id);
}
