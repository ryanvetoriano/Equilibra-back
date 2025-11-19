package br.com.fiap.bo;

import br.com.fiap.dao.MetaDAO;
import br.com.fiap.model.Meta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class MetaBO {

    @Inject
    MetaDAO dao;

    public List<Meta> listar() { return dao.listAll(); }

    public Meta buscar(Long id) { return dao.findById(id); }

    public void salvar(Meta m) { dao.persist(m); }

    public boolean deletar(Long id) { return dao.deleteById(id); }
}
