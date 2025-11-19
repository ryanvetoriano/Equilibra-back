package br.com.fiap.bo;

import br.com.fiap.dao.TarefaDAO;
import br.com.fiap.model.Tarefa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TarefaBO {

    @Inject
    TarefaDAO dao;

    public List<Tarefa> listar() { return dao.listAll(); }

    public Tarefa buscar(Long id) { return dao.findById(id); }

    public void salvar(Tarefa tarefa) { dao.persist(tarefa); }

    public boolean deletar(Long id) { return dao.deleteById(id); }

    public List<Tarefa> listarPorUsuario(Long idUsuario) {
        return dao.list("usuario.idUsuario", idUsuario);
    }
}
