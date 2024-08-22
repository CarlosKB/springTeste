package _Desk.Thy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; // Importar Service
import org.springframework.transaction.annotation.Transactional; // Importar Transactional
import org.springframework.web.server.ResponseStatusException; // Importar ResponseStatusException
import org.springframework.http.HttpStatus; // Importar HttpStatus

import _Desk.Thy.entity.Usuario;
import _Desk.Thy.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    // Construtor é opcional se você já usa @Autowired
    public UsuarioServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional // Somente faz commit ao final do método
    public Usuario novoUsuario(Usuario usuario) {
        if (usuario == null || usuario.getSenha() == null || usuario.getNome() == null
                || usuario.getSenha().isBlank() || usuario.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome ou senha inválidos!"); // Corrigir a criação da exceção
        }
        return repo.save(usuario);
    }

    @Override
    public List<Usuario> todosUsuarios() {
        // Retornar diretamente a lista encontrada
        return (List<Usuario>) repo.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOp = repo.findById(id);
        if (usuarioOp.isEmpty()) { // Corrigir verificação para Optional
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado!");
        }
        return usuarioOp.get();
    }
}
