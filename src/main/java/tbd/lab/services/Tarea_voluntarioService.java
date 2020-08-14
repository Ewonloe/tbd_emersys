package tbd.lab.services;


import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Tarea_voluntario;
import tbd.lab.Repositories.Tarea_voluntarioRepository;

import java.util.List;

@CrossOrigin
@RestController
public class Tarea_voluntarioService {

    private final Tarea_voluntarioRepository tar_volRepo;
    Tarea_voluntarioService(Tarea_voluntarioRepository tar_volRepo) { this.tar_volRepo = tar_volRepo; }

    @GetMapping("/tarea_voluntarios/all")
    public List<Tarea_voluntario> getAllTarea_voluntario() {return tar_volRepo.getAllTarea_voluntario();}

    @GetMapping("/tarea_voluntarios/count")
    public String countTarea_voluntario()
    {
        int count = tar_volRepo.countTarea_voluntario();
        return String.format("Hay %s tarea_voluntarios", count);
    }

    @PostMapping("/tarea_voluntarios/add")
    @ResponseBody
    public String createTarea_voluntario(@RequestBody Tarea_voluntario tarea_voluntario)
    {
        return tar_volRepo.createTarea_voluntario(tarea_voluntario);
    }

    @GetMapping("tarea_voluntarios/{id}")
    public Tarea_voluntario getTarea_voluntario(@PathVariable(value = "id") Integer id)
    {
        return tar_volRepo.getTarea_voluntario(id);
    }

    @PutMapping("tarea_voluntarios/update/{id}")
    @ResponseBody
    public String updateTarea_voluntario(@RequestBody Tarea_voluntario tarea_voluntario, @PathVariable(value = "id") Integer id)
    {
        return tar_volRepo.updateTarea_voluntario(tarea_voluntario, id);
    }

    @DeleteMapping("tarea_voluntarios/delete/{id}")
    public String deleteTarea_voluntario(@PathVariable(value = "id") Integer id)
    {
        return tar_volRepo.deleteTarea_voluntario(id);
    }
}
