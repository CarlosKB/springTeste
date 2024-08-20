package _Desk.Thy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.IllegalTransactionStateException;

import _Desk.Thy.entity.Usuario;
import _Desk.Thy.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repo;

    public UsuarioServiceImpl(UsuarioRepository repo){
        this.repo = repo;
    }

    @Override
    @Transactional//Só faz o commit ao final do metodo
    public Usuario novoUsuario(Usuario usuario) {
        if(usuario == null || usuario.getSenha() == null || usuario.getNome() == null
        || usuario.getSenha().isBlank() || usuario.getNome().isBlank()){
            throw new IllegalArgumentException(s:"Nome ou senha invalidos!");
        }
        return repo.save(usuario);
    }

    @Override
    public List<Usuario> todosUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        for(Usuario u: repo.findAll()){
            usuarios.add(u);
        }
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<Usuario> usuarioOp = repo.findById(id);
        if(usuarioOp == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não encontrado!");
        return usuarioOp.get();
    }
    
}
