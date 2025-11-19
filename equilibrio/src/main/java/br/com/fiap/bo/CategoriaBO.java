package br.com.fiap.bo;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.model.Categoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CategoriaBO {

    @Inject
    CategoriaDAO dao;

    public List<Categoria> listar() { return dao.listAll(); }

    public Categoria buscar(Long id) { return dao.findById(id); }

    public void salvar(Categoria c) { dao.persist(c); }

    public boolean deletar(Long id) { return dao.deleteById(id); }
}
