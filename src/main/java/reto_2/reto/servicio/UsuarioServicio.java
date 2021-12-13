package reto_2.reto.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reto_2.reto.modelo.Usuario;
import reto_2.reto.repositorio.UsuarioOperaciones;

@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioOperaciones operaciones;

    public List<Usuario> getAll() {
        return operaciones.getAll();
    }

    public Optional<Usuario> getUsuario(int id) {
        return operaciones.getUsuario(id);
    }

    public Usuario salvar(Usuario usuario) {
        if(usuario.getId() == null) {
            return operaciones.salvar(usuario);
        } else {
            Optional<Usuario> revisar = operaciones.getUsuario(usuario.getId());
            if(revisar.isEmpty()) {
                return operaciones.salvar(usuario);
            } else {
                return usuario;
            }
        }
    }

    public Usuario actualizar(Usuario usuario) {
        if(usuario.getId() != null) {
            Optional<Usuario> consulta = operaciones.getUsuario(usuario.getId());
            if(!consulta.isEmpty()) {
                // if(usuario.getId() != null) {
                //     consulta.get().setId(usuario.getId());
                // }
                if(usuario.getIdentification() != null) {
                    consulta.get().setIdentification(usuario.getIdentification());
                }
                if(usuario.getName() != null) {
                    consulta.get().setName(usuario.getName());
                }
                if(usuario.getAddress() != null) {
                    consulta.get().setAddress(usuario.getAddress());
                }
                if(usuario.getCellPhone() != null) {
                    consulta.get().setCellPhone(usuario.getCellPhone());
                }
                if(usuario.getEmail() != null) {
                    consulta.get().setEmail(usuario.getEmail());
                }
                if(usuario.getPassword() != null) {
                    consulta.get().setPassword(usuario.getPassword());
                }
                if(usuario.getZone() != null) {
                    consulta.get().setZone(usuario.getZone());
                }
                if(usuario.getType() != null) {
                    consulta.get().setType(usuario.getType());
                }
                return operaciones.salvar(consulta.get());
            }
        }
        return usuario;
    }

    public boolean borrar(int id) {
        Optional<Usuario> user = operaciones.getUsuario(id);
        if(!user.isEmpty()) {
            operaciones.borrar(user.get());
            return true;
        }
        return false;
    }

    public boolean validarEmail(String email) {
        Optional<Usuario> validar = operaciones.buscarEmail(email);
        if(!validar.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Usuario autenticacion(String email, String password) {
        Optional<Usuario> usuarioExiste = operaciones.emailPassword(email, password);
        if(usuarioExiste.isEmpty()) {
            return new Usuario();
        } else {
            return usuarioExiste.get();
        }
    }

}
