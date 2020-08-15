package tbd.lab.Repositories;

import tbd.lab.Models.Emergencia;
import tbd.lab.Models.Habilidad;
import tbd.lab.Models.Tarea;

import java.util.List;

public interface EmergenciaRepository {
    public int countEmergencia();
    public List<Emergencia> getAllEmergencia();
    public String createEmergencia(Emergencia emergencia);
    public Emergencia getEmergencia(Integer id);
    public String updateEmergencia(Emergencia emergencia, Integer id);
    public String deleteEmergencia(Integer id);

    // Listar tareas de la emergencia.
    public List<Tarea> getTareas(Integer id);

    public List<Habilidad> getHabilidades(Integer id);

    // Obtener promedio de puntaje en una emergencia
    public List<Emergencia> getRankingAvg(Integer id);
}
