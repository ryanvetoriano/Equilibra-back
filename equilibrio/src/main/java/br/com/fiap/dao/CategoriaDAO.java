package br.com.fiap.dao;

import br.com.fiap.model.Categoria;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoriaDAO implements PanacheRepositoryBase<Categoria, Long> { }
