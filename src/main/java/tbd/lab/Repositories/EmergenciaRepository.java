package tbd.lab.Repositories;

import tbd.lab.Models.Emergencia;

import java.util.List;

public interface EmergenciaRepository {
    public int countEmergencia();
    public List<Emergencia> getAllEmergencia();
    public String createEmergencia(Emergencia emergencia);
    public Emergencia getEmergencia(Integer id);
    public String updateEmergencia(Emergencia emergencia, Integer id);
    public String deleteEmergencia(Integer id);
}
