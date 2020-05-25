package tbd.lab.Repositories;

import tbd.lab.Models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {
    public int countVoluntario();
    public List<Voluntario> getAllVoluntario();
    public Voluntario createVoluntario(Voluntario voluntario);
    public Voluntario getVoluntario(Integer id);
    public Voluntario updateVoluntario(Voluntario voluntario, Integer id);
    public void deleteVoluntario(Integer id);
}
