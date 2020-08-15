package tbd.lab.Repositories;

import tbd.lab.Models.Tarea_habilidad;

import java.util.List;

public interface Tarea_habilidadRepository {

    public int countTarea_habilidad();
    public List<Tarea_habilidad> getAllTarea_habilidad();
    public String createTarea_habilidad(Tarea_habilidad tarea_habilidad);
    public Tarea_habilidad getTarea_habilidad(Integer id);
    public String updateTarea_habilidad(Tarea_habilidad tarea_habilidad, Integer id);
    public String deleteTarea_habilidad(Integer id);
}
