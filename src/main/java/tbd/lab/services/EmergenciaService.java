package tbd.lab.services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Emergencia;
import tbd.lab.Repositories.EmergenciaRepository;

import java.util.List;

@CrossOrigin
@RestController
public class EmergenciaService {

    private final EmergenciaRepository emerRepo;
    EmergenciaService(EmergenciaRepository emerRepo)
    {
        this.emerRepo = emerRepo;
    }

    @GetMapping("/emergencias/all")
    public List<Emergencia> getAllEmergencia()
    {
        return emerRepo.getAllEmergencia();
    }

    @GetMapping("/emergencias/count")
    public String countEmergencia()
    {
        int count = emerRepo.countEmergencia();
        return String.format("Hay %s emergencia(s)", count);
    }

    @PostMapping("/emergencias/add")
    @ResponseBody
    public String createEmergencia(@RequestBody Emergencia emergencia)
    {
        return emerRepo.createEmergencia(emergencia);
    }

    @GetMapping("/emergencias/{id}")
    public Emergencia getEmergencia(@PathVariable(value = "id") Integer id)
    {
        return emerRepo.getEmergencia(id);
    }

    @PutMapping("/emergencias/update/{id}")
    public String updateEmergencia(@RequestBody Emergencia emergencia, @PathVariable(value = "id") Integer id)
    {
        return emerRepo.updateEmergencia(emergencia, id);
    }

    @DeleteMapping("/emergencias/delete/{id}")
    public String deleteEmergencia(@PathVariable(value = "id") Integer id)
    {
        return emerRepo.deleteEmergencia(id);
    }
}
