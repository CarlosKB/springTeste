package _Desk.Thy.entity;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "aut_autorizacao")
public class Autorizacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aut_id")
    @JsonView({View.AutorizacaoView.class})
    private Long id;

    @Column(name = "aut_nome")
    @JsonView({View.UsuarioView.class, View.AutorizacaoView.class})
    private String nome;

    @ManyToMany(mappedBy = "autorizacoes")
    private Set<Usuario> usuarios;

    public Long getId() {
        return id;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
