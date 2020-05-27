package tbd.lab.services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Tarea;
import tbd.lab.Repositories.TareaRepository;

import java.util.List;

@CrossOrigin
@RestController
public class TareaService {

    private final TareaRepository tarRepo;
    TareaService(TareaRepository tarRepo)
    {
        this.tarRepo = tarRepo;
    }

    @GetMapping("/tareas/all")
    public List<Tarea> getAllTarea()
    {
        return tarRepo.getAllTarea();
    }

    @GetMapping("/tareas/count")
    public String countTarea()
    {
        int count = tarRepo.countTarea();
        return String.format("Hay %s tarea(s)", count);
    }

    @PostMapping("/tareas/add")
    @ResponseBody
    public String createTarea(@RequestBody Tarea tarea)
    {
        return tarRepo.createTarea(tarea);
    }

    @GetMapping("/tareas/{id}")
    public Tarea getTarea(@PathVariable(value = "id") Integer id)
    {
        return tarRepo.getTarea(id);
    }

    @PutMapping("/tareas/update/{id}")
    @ResponseBody
    public String updateTarea(@RequestBody Tarea tarea, @PathVariable(value = "id") Integer id)
    {
        return tarRepo.updateTarea(tarea, id);
    }

    @DeleteMapping("/tareas/delete/{id}")
    public String deleteTarea(@PathVariable(value = "id") Integer id)
    {
        return tarRepo.deleteTarea(id);
    }


}
