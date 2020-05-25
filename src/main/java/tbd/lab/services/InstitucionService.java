package tbd.lab.services;

import org.springframework.web.bind.annotation.*;
import tbd.lab.Models.Institucion;
import tbd.lab.Repositories.InstitucionRepository;

import java.util.List;

@CrossOrigin
@RestController
public class InstitucionService {

    private final InstitucionRepository insRepo;
    InstitucionService(InstitucionRepository insRepo)
    {
        this.insRepo = insRepo;
    }

    @GetMapping("/instituciones/all")
    public List<Institucion> getAllInstitucion()
    {
        return insRepo.getAllInstitucion();
    }

    @GetMapping("/instituciones/count")
    public String countInstitucion()
    {
        int count = insRepo.countInstitucion();
        return String.format("Hay %s instituciones", count);
    }

    @PostMapping("/instituciones/add")
    @ResponseBody
    public String createInstitucion(@RequestBody Institucion institucion)
    {
        return insRepo.createInstitucion(institucion);
    }

    @GetMapping("/instituciones/{id}")
    public Institucion getInstitucion(@PathVariable(value = "id") Integer id)
    {
        return insRepo.getInstitucion(id);
    }

    @PutMapping("/instituciones/update/{id}")
    @ResponseBody
    public String updateInstitucion(@RequestBody Institucion institucion, @PathVariable(value = "id") Integer id)
    {
        return insRepo.updateInstitucion(institucion, id);
    }

    @DeleteMapping("/instituciones/delete/{id}")
    public String deleteInstitucion(@PathVariable(value = "id") Integer id)
    {
        return insRepo.deleteInstitucion(id);
    }
}
