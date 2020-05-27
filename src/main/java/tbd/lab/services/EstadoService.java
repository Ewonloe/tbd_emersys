package tbd.lab.services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Estado;
import tbd.lab.Repositories.EstadoRepository;

import java.util.List;

@CrossOrigin
@RestController
public class EstadoService {

    private final EstadoRepository estRepo;
    EstadoService(EstadoRepository estRepo)
    {
        this.estRepo = estRepo;
    }

    @GetMapping("/estados/all")
    public List<Estado> getAllEstado()
    {
        return estRepo.getAllEstado();
    }

    @GetMapping("/estados/count")
    public String countEstado()
    {
        int count = estRepo.countEstado();
        return String.format("Hay %s estado(s)", count);
    }

    @PostMapping("/estados/add")
    @ResponseBody
    public String createEstado(@RequestBody Estado estado)
    {
        return estRepo.createEstado(estado);
    }

    @GetMapping("/estados/{id}")
    public Estado getEstado(@PathVariable(value = "id") Integer id)
    {
        return estRepo.getEstado(id);
    }

    @PutMapping("/estados/update/{id}")
    @ResponseBody
    public String updateEstado(@RequestBody Estado estado, @PathVariable(value = "id") Integer id)
    {
        return estRepo.updateEstado(estado, id);
    }

    @DeleteMapping("/estados/delete/{id}")
    public String deleteEstado(@PathVariable(value = "id") Integer id)
    {
        return estRepo.deleteEstado(id);
    }
}
