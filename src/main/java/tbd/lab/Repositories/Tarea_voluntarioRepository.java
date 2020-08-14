package tbd.lab.Repositories;

import tbd.lab.Models.Tarea;
import tbd.lab.Models.Tarea_voluntario;

import java.util.List;

public interface Tarea_voluntarioRepository {

    public int countTarea_voluntario();
    public List<Tarea_voluntario> getAllTarea_voluntario();
    public String createTarea_voluntario(Tarea_voluntario tarea_voluntario);
    public Tarea_voluntario getTarea_voluntario(Integer id);
    public String updateTarea_voluntario(Tarea_voluntario tarea_voluntario, Integer id);
    public String deleteTarea_voluntario(Integer id);

}
