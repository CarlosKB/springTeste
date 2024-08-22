package _Desk.Thy.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import _Desk.Thy.entity.Usuario;
import _Desk.Thy.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")//Para a request bater aqui /usuario
@CrossOrigin()
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @GetMapping(value = "/allUsers")
    public List<Usuario> todosUsuarios(){
        return service.todosUsuarios();
    }

    @PostMapping(value = "/setUser")
    public Usuario novoUsuario(@RequestBody Usuario usuario){
        return service.novoUsuario(usuario);
    }

    @GetMapping(value = "/getUserById")
    public Usuario buscalPorId(@PathVariable("id") Long id){
        return service.buscarPorId(id);
    }

}
