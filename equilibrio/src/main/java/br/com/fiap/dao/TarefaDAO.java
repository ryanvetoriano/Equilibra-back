package br.com.fiap.dao;

import br.com.fiap.model.Tarefa;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TarefaDAO implements PanacheRepositoryBase<Tarefa, Long> { }
