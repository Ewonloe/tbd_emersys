package tbd.lab.Repositories;

import tbd.lab.Models.Voluntario;

import java.util.List;

public interface VoluntarioRepository {
    public int countVoluntario();
    public List<Voluntario> getAllVoluntario();
    public String createVoluntario(Voluntario voluntario);
    public Voluntario getVoluntario(Integer id);
    public String updateVoluntario(Voluntario voluntario, Integer id);
    public String deleteVoluntario(Integer id);
    public List<Voluntario> getRankingBetween(Float minValue, Float maxValue);
    public List<Voluntario> getVolWithName(String name);
}
