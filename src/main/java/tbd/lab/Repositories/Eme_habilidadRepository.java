package tbd.lab.Repositories;

import tbd.lab.Models.Eme_habilidad;

import java.util.List;

public interface Eme_habilidadRepository {

    public int countEme_habilidad();
    public List<Eme_habilidad> getAllEme_habilidad();
    public String createEme_habilidad(Eme_habilidad eme_habilidad);
    public Eme_habilidad getEme_habilidad(Integer id);
    public String updateEme_habilidad(Eme_habilidad eme_habilidad, Integer id);
    public String deleteEme_habilidad(Integer id);
}
