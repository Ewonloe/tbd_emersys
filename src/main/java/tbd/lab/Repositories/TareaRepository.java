package tbd.lab.Repositories;

import tbd.lab.Models.Tarea;

import java.util.List;

public interface TareaRepository {
    public int countTarea();
    public List<Tarea> getAllTarea();
    public String createTarea(Tarea tarea);
    public Tarea getTarea(Integer id);
    public String updateTarea(Tarea tarea, Integer id);
    public String deleteTarea(Integer id);
}
