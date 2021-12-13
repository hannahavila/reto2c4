package reto_2.reto.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reto_2.reto.modelo.Usuario;

@Repository
public class UsuarioOperaciones {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> getAll() {
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> getUsuario(int id) {
        return usuarioRepositorio.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public void borrar(Usuario usuario) {
        usuarioRepositorio.delete(usuario);
    }

    public Optional<Usuario> buscarEmail(String email) {
        return usuarioRepositorio.findUsuarioByEmail(email);
    }

    public Optional<Usuario> emailPassword(String email, String password) {
        return usuarioRepositorio.findUsuarioByEmailAndPassword(email, password);
    }

}
