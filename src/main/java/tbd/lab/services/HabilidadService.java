package tbd.lab.services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Habilidad;
import tbd.lab.Repositories.HabilidadRepository;

import java.util.List;

@CrossOrigin
@RestController
public class HabilidadService {

    private final HabilidadRepository habRepo;

    HabilidadService(HabilidadRepository habRepo)
    {
        this.habRepo = habRepo;
    }

    @GetMapping("/habilidades/all")
    public List<Habilidad> getAllHabilidad()
    {
        return habRepo.getAllHabilidad();
    }

    @GetMapping("/habilidades/count")
    public String countHabilidad()
    {
        int count = habRepo.countHabilidad();
        return String.format("Hay %s habilidad(es)", count);
    }

    @PostMapping("/habilidades/add")
    @ResponseBody
    public String createHabilidad(@RequestBody Habilidad habilidad)
    {
        return habRepo.createHabilidad(habilidad);
    }

    @GetMapping("/habilidades/{id}")
    public Habilidad getHabilidad(@PathVariable(value = "id") Integer id)
    {
        return habRepo.getHabilidad(id);
    }

    @PutMapping("/habilidades/update/{id}")
    @ResponseBody
    public String updateHabilidad(@RequestBody Habilidad habilidad, @PathVariable(value = "id") Integer id)
    {
        return habRepo.updateHabilidad(habilidad, id);
    }

    @DeleteMapping("/habilidades/delete/{id}")
    public String deleteHabilidad(@PathVariable(value = "id") Integer id)
    {
        return habRepo.deleteHabilidad(id);
    }
}
