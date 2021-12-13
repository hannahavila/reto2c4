package reto_2.reto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto_2.reto.modelo.Chocolate;

@Repository
public class ChocolateOperaciones {

    @Autowired
    private ChocolateRepositorio repositorio;

    public List<Chocolate> getAll() {
        return repositorio.findAll();
    }

    public Optional<Chocolate> getChocolate(String reference) {
        return repositorio.findById(reference);
    }

    public Chocolate salvar(Chocolate chocolate) {
        return repositorio.save(chocolate);
    }

    public void borrar(Chocolate chocolate) {
        repositorio.delete(chocolate);
    }

}
