package tbd.lab.Repositories;

import tbd.lab.Models.Habilidad;
import tbd.lab.Models.Tarea;
import tbd.lab.Models.Voluntario;

import java.util.List;

public interface TareaRepository {
    public int countTarea();
    public List<Tarea> getAllTarea();
    public String createTarea(Tarea tarea);
    public Tarea getTarea(Integer id);
    public String updateTarea(Tarea tarea, Integer id);
    public String deleteTarea(Integer id);
    public List<Habilidad> getHabilidades(Integer id);
    public List<Habilidad> getMissingHabilidades(Integer id);
    public List<Voluntario> getUnsummoned(Integer id);
}
