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

import reto_2.reto.modelo.Usuario;
import reto_2.reto.servicio.UsuarioServicio;

/**
 * 
 * @author User
 */
@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioControlador {

    /**
     * 
     * instanciacion de servicio
     */
    @Autowired
    private UsuarioServicio servicio;

    /**
     * 
     * @return regresa una lista de todos los usuarios en la base de datos
     */
    @GetMapping("/all")
    public List<Usuario> getAll() {
        return servicio.getAll();
    }

    /**
     * 
     * @param id recibe un valor entero de id
     * @return regresa el usuario que coincide con la id
     */
    @GetMapping("/consulta/{id}")
    public Optional<Usuario> getUsuario(@PathVariable("id") int id) {
        return servicio.getUsuario(id);
    }

    /**
     * 
     * @param usuario recibe un objeto de tipo Usuario
     * @return regresa los nuevos valores del usuario
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario actualizar(@RequestBody Usuario usuario) {
        return servicio.actualizar(usuario);
    }

    /**
     * 
     * @param usuario recibe objeto de tipo usuario
     * @return regresa un usuario
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody Usuario usuario) {
        return servicio.salvar(usuario);
    }

    /**
     * 
     * @param id recibe un valor entero de id
     * @return elimina los valores de usuario
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean borrar(@PathVariable("id") int id) {
        return servicio.borrar(id);
    }

    /**
     * 
     * @param email recibe una cadena de texto para email
     * @return regresa true si encuentra el correo en la base o falso si no exixte
     */
    @GetMapping("/emailexist/{email}")
    public boolean correoExixtente(@PathVariable ("email") String email) {
        return servicio.validarEmail(email);
    }

    /**
     * 
     * @param email recibe una cadena de texto de email
     * @param password reribe una cadena de texto para password
     * @return regresa un usuario que coincida con la contraseña y correo
     */
    @GetMapping("/{email}/{password}")
    public Usuario usuarioExiste(@PathVariable("email") String email, @PathVariable("password") String password) {
        return servicio.autenticacion(email, password);
    }

}