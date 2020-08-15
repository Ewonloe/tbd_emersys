package tbd.lab.services;


import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Tarea_habilidad;
import tbd.lab.Repositories.Tarea_habilidadRepository;

import java.util.List;

@CrossOrigin
@RestController
public class Tarea_habilidadService {

    private final Tarea_habilidadRepository tar_habRepo;
    Tarea_habilidadService(Tarea_habilidadRepository tar_habRepo) { this.tar_habRepo = tar_habRepo; }

    @GetMapping("/tarea_habilidades/all")
    public List<Tarea_habilidad> getAllTarea_voluntario() {return tar_habRepo.getAllTarea_habilidad();}

    @GetMapping("/tarea_habilidades/count")
    public String countTarea_voluntario()
    {
        int count = tar_habRepo.countTarea_habilidad();
        return String.format("Hay %s tarea_habilidades", count);
    }

    @PostMapping("/tarea_habilidades/add")
    @ResponseBody
    public String createTarea_voluntario(@RequestBody Tarea_habilidad tarea_habilidad)
    {
        return tar_habRepo.createTarea_habilidad(tarea_habilidad);
    }

    @GetMapping("tarea_habilidades/{id}")
    public Tarea_habilidad getTarea_voluntario(@PathVariable(value = "id") Integer id)
    {
        return tar_habRepo.getTarea_habilidad(id);
    }

    @PutMapping("tarea_habilidades/update/{id}")
    @ResponseBody
    public String updateTarea_voluntario(@RequestBody Tarea_habilidad tarea_habilidad, @PathVariable(value = "id") Integer id)
    {
        return tar_habRepo.updateTarea_habilidad(tarea_habilidad, id);
    }

    @DeleteMapping("tarea_habilidades/delete/{id}")
    public String deleteTarea_voluntario(@PathVariable(value = "id") Integer id)
    {
        return tar_habRepo.deleteTarea_habilidad(id);
    }

}
