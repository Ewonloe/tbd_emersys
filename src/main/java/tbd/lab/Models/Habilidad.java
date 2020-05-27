package tbd.lab.Models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Habilidad {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String descripcion;

}