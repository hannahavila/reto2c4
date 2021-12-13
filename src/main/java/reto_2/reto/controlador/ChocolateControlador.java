package reto_2.reto.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reto_2.reto.modelo.Chocolate;
import reto_2.reto.servicio.ChocolateServicio;

@RestController
@RequestMapping("/api/chocolate")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ChocolateControlador {

    @Autowired
    private ChocolateServicio servicio;

    @GetMapping("/all")
    public List<Chocolate> getAll() {
        return servicio.getAll();
    }

    @GetMapping("/consulta/{reference}")
    public Optional<Chocolate> getChocolate(@PathVariable("reference") String reference) {
        return servicio.getChocolate(reference);
    }

    @PostMapping("/new")
    public Chocolate salvar(@RequestBody Chocolate chocolate) {
        return servicio.salvar(chocolate);
    }

    @PutMapping("/update")
    public Chocolate actualizar(@RequestBody Chocolate chocolate) {
        return servicio.actualizar(chocolate);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrar(@PathVariable("reference") String reference) {
        return servicio.borrar(reference);
    }

}
