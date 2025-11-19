package br.com.fiap.dao;

import br.com.fiap.model.Meta;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MetaDAO implements PanacheRepositoryBase<Meta, Long> { }
