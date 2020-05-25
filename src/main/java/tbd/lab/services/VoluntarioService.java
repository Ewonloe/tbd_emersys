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
        Voluntario vol = volRepo.createVoluntario(voluntario);
        return vol;
    }


    @GetMapping("/voluntarios/{id}")
    public Voluntario getVoluntario(@PathVariable(value = "id") Integer id)
    {
        Voluntario vol = volRepo.getVoluntario(id);
        return vol;
    }

    @PutMapping("voluntarios/update/{id}")
    @ResponseBody
    public Voluntario updateVoluntario(@RequestBody Voluntario voluntario, @PathVariable(value = "id") Integer id)
    {
        Voluntario vol = volRepo.updateVoluntario(voluntario, id);
        return vol;
    }

    @DeleteMapping("/voluntarios/delete/{id}")
    public String deleteVoluntario(@PathVariable(value = "id") Integer id)
    {
        volRepo.deleteVoluntario(id);
        return "Voluntario eliminado exitosamente";
    }
}
