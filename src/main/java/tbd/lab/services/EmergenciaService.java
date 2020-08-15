package tbd.lab.services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Emergencia;
import tbd.lab.Models.Habilidad;
import tbd.lab.Models.Tarea;
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
    @ResponseBody
    public String updateEmergencia(@RequestBody Emergencia emergencia, @PathVariable(value = "id") Integer id)
    {
        return emerRepo.updateEmergencia(emergencia, id);
    }

    @DeleteMapping("/emergencias/delete/{id}")
    public String deleteEmergencia(@PathVariable(value = "id") Integer id)
    {
        return emerRepo.deleteEmergencia(id);
    }

    @GetMapping("/emergencias/getTareas/{id}")
    public List<Tarea> getTareas(@PathVariable(value= "id") Integer id)
    {
        return emerRepo.getTareas(id);
    }

    @GetMapping("/emergencias/getHabilidades/{id}")
    public List<Habilidad> getHabilidades(@PathVariable(value= "id") Integer id)
    {
        return emerRepo.getHabilidades(id);
    }

    @GetMapping("/emergencias/getMissingHabilidades/{id}")
    public List<Habilidad> getMissingHabilidades(@PathVariable(value= "id") Integer id)
    {
        return emerRepo.getMissingHabilidades(id);
    }

    @GetMapping("/emergencias/getRankingAvg/{id}")
    public List<Emergencia> getRankingAvg(@PathVariable(value= "id") Integer id)
    {
        return emerRepo.getRankingAvg(id);
    }
}
