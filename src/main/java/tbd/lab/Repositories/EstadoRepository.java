package tbd.lab.Repositories;

import tbd.lab.Models.Estado;

import java.util.List;

public interface EstadoRepository {
    public int countEstado();
    public List<Estado> getAllEstado();
    public String createEstado(Estado estado);
    public Estado getEstado(Integer id);
    public String updateEstado(Estado estado, Integer id);
    public String deleteEstado(Integer id);
}
