package reto_2.reto.repositorio;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import reto_2.reto.modelo.Usuario;

public interface UsuarioRepositorio extends MongoRepository<Usuario, Integer> {

    @Query("{email: ?0}")
    Optional<Usuario> findUsuarioByEmail(String email);
    // @Query("{$and:[{{email: ?0}, {password: ?0}}]}")
    Optional<Usuario> findUsuarioByEmailAndPassword(String email, String password);

}
