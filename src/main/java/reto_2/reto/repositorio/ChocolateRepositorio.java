package reto_2.reto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import reto_2.reto.modelo.Chocolate;

public interface ChocolateRepositorio extends MongoRepository<Chocolate, String> {
    
}
