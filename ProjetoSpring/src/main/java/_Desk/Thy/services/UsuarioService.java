package _Desk.Thy.services;

import java.util.List;

import _Desk.Thy.entity.Usuario;

public interface UsuarioService {

    public Usuario novoUsuario(Usuario usuario);

    public List<Usuario> todosUsuarios();

    public Usuario buscarPorId(Long id);
}
