package tbd.lab.services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Eme_habilidad;
import tbd.lab.Repositories.Eme_habilidadRepository;

import java.util.List;

@CrossOrigin
@RestController
public class Eme_habilidadService {

    private final Eme_habilidadRepository eme_habRepo;

    Eme_habilidadService(Eme_habilidadRepository eme_habRepo)
    {
        this.eme_habRepo = eme_habRepo;
    }

    @GetMapping("/eme_habilidades/all")
    public List<Eme_habilidad> getAllEme_habilidad()
    {
        return eme_habRepo.getAllEme_habilidad();
    }

    @GetMapping("/eme_habilidades/count")
    public String countEme_habilidad()
    {
        int count = eme_habRepo.countEme_habilidad();
        return String.format("Hay %s eme_habilidad(es)", count);
    }

    @PostMapping("/eme_habilidades/add")
    @ResponseBody
    public String createEme_habilidad(@RequestBody Eme_habilidad eme_habilidad)
    {
        return eme_habRepo.createEme_habilidad(eme_habilidad);
    }

    @GetMapping("/eme_habilidades/{id}")
    public Eme_habilidad getEme_habilidad(@PathVariable(value = "id") Integer id)
    {
        return eme_habRepo.getEme_habilidad(id);
    }

    @PutMapping("/eme_habilidades/update/{id}")
    @ResponseBody
    public String updateEme_habilidad(@RequestBody Eme_habilidad eme_habilidad, @PathVariable(value = "id") Integer id)
    {
        return eme_habRepo.updateEme_habilidad(eme_habilidad, id);
    }

    @DeleteMapping("/eme_habilidades/delete/{id}")
    public String deleteEme_habilidad(@PathVariable(value = "id") Integer id)
    {
        return eme_habRepo.deleteEme_habilidad(id);
    }
}
