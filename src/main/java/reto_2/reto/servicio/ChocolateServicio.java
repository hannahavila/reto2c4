package reto_2.reto.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto_2.reto.modelo.Chocolate;
import reto_2.reto.repositorio.ChocolateOperaciones;

@Service
public class ChocolateServicio {

    @Autowired
    private ChocolateOperaciones operaciones;

    public List<Chocolate> getAll() {
        return operaciones.getAll();
    }

    public Optional<Chocolate> getChocolate(String reference) {
        return operaciones.getChocolate(reference);
    }

    public Chocolate salvar(Chocolate chocolate) {
        if(chocolate.getReference() == null) {
            return operaciones.salvar(chocolate);
        } else {
            Optional<Chocolate> revisar = operaciones.getChocolate(chocolate.getReference());
            if(revisar.isEmpty()) {
                return operaciones.salvar(chocolate);
            } else {
                return chocolate;
            }
        }
    }

    public Chocolate actualizar(Chocolate chocolate) {
        if(chocolate.getReference() != null) {
            Optional<Chocolate> consulta = operaciones.getChocolate(chocolate.getReference());
            if(!consulta.isEmpty()) {
                if(chocolate.getCategory() != null) {
                    consulta.get().setCategory(chocolate.getCategory());
                }
                if(chocolate.getDescription() != null) {
                    consulta.get().setDescription(chocolate.getDescription());
                }
                if(chocolate.getPrice() != 0) {
                    consulta.get().setPrice(chocolate.getPrice());
                }
                if(chocolate.getQuantity() != 0) {
                    consulta.get().setQuantity(chocolate.getQuantity());
                }
                if(chocolate.getPhotography() != null) {
                    consulta.get().setPhotography(chocolate.getPhotography());
                }
                return operaciones.salvar(consulta.get());
            }
        }
        return chocolate;
    }

    public boolean borrar(String reference) {
        Optional<Chocolate> chocolate = operaciones.getChocolate(reference);
        if(!chocolate.isEmpty()) {
            operaciones.borrar(chocolate.get());
            return true;
        }
        return false;
    }

}
