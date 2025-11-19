package br.com.fiap.dao;

import br.com.fiap.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioDAO implements PanacheRepositoryBase<Usuario, Long> { }
