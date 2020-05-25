package tbd.lab.services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Voluntario;
import tbd.lab.Repositories.VoluntarioRepository;

import java.util.List;

@CrossOrigin
@RestController
public class VoluntarioService {

    private final VoluntarioRepository volRepo;
    VoluntarioService(VoluntarioRepository volRepo)
    {
        this.volRepo = volRepo;
    }

    @GetMapping("/voluntarios/all")
    public List<Voluntario> getAllVoluntario()
    {
        return volRepo.getAllVoluntario();
    }

    @GetMapping("/voluntarios/count")
    public String countVoluntario()
    {
        int count = volRepo.countVoluntario();
        return String.format("Hay %s voluntarios", count);
    }

    @PostMapping("/voluntarios/add")
    @ResponseBody
    public Voluntario createVoluntario(@RequestBody Voluntario voluntario)
    {
        return volRepo.createVoluntario(voluntario);
    }


    @GetMapping("/voluntarios/{id}")
    public Voluntario getVoluntario(@PathVariable(value = "id") Integer id)
    {
        return volRepo.getVoluntario(id);
    }

    @PutMapping("/voluntarios/update/{id}")
    @ResponseBody
    public Voluntario updateVoluntario(@RequestBody Voluntario voluntario, @PathVariable(value = "id") Integer id)
    {
        return volRepo.updateVoluntario(voluntario, id);
    }

    @DeleteMapping("/voluntarios/delete/{id}")
    public String deleteVoluntario(@PathVariable(value = "id") Integer id)
    {
        volRepo.deleteVoluntario(id);
        return "Voluntario eliminado exitosamente";
    }
}