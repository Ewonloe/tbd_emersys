package tbd.lab.Repositories;

import tbd.lab.Models.Habilidad;

import java.util.List;

import java.util.List;

public interface HabilidadRepository {
    public int countHabilidad();
    public List<Habilidad> getAllHabilidad();
    public String createHabilidad(Habilidad habilidad);
    public Habilidad getEstado(Integer id);
    public String updateEstado(Habilidad habilidad, Integer id);
    public String deleteEstado(Integer id);
}
